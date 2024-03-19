<template>
  <div>
    <el-row>
      <el-col :span="4">
        <div class="div1"><LeftBat></LeftBat></div
      ></el-col>

      <el-col :span="20">
        <div v-if="page === 1">
          <div class="card" v-if="iftest === 0">
            <h2><strong>处方评测</strong> 简介</h2>
            <div>
              <small
                >由于您未完成<strong>个人体制评测</strong>，所以暂未为您生成运动处方，如果想要获得合适的运动处方，请您尽快完成相关评测</small
              >
            </div>
            <div>
              <el-button round class="m-t-5" type="text" @click="access()"
                >立即测评</el-button
              >
            </div>
          </div>
          <div class="card" v-if="iftest === 1">
            <h2>
              您最近一次体制评测成绩为 ：<strong>{{ score }}</strong>
            </h2>

            <div>
              <el-button round class="m-t-5" type="text" @click="access"
                >重新测评</el-button
              >
            </div>
          </div>

          <div class="card">
            <span style="font-size: 20px; font-weight: 1000; margin:10px; "
              >根据您最近一次的测量结果您可以选择以下运动处方</span
            >
            <el-row style="margin-top: 20px;">
              <el-col
                style="margin-bottom: 10px;"
                :span="8"
                v-for="(o, index) in standard"
                :key="o"
              >
                <el-card :body-style="{ padding: '10px' }">
                  <img :src="o.videoUrl" class="image" />
                  <div style="padding: 14px;">
                    <span>{{ o.name }}</span>
                    <div class="bottom clearfix">
                      <time class="time">{{ currentDate }}</time>
                      <el-button
                        type="text"
                        class="selectStandard"
                        @click="watchdetail(index)"
                        style="margin-left: 40%;"
                        >查看详情</el-button
                      >
                    </div>
                  </div>
                </el-card>
              </el-col>
            </el-row>
          </div>
          <!-- v-if="isaccess === true" -->
          <el-dialog
            title="体制评测（可选填）"
            :visible.sync="dialogVisible"
            width="70%"
            :before-close="handleClose"
          >
            <div class="card m-t-5">
              <!-- <h2
              style="color: rgb(86,156,203); font-size: 40px; text-align: center;"
            >
              体制测评(填写数据越全越精准)
            </h2> -->
              <el-form ref="form" :model="healthaccess" label-width="80px">
                <el-row :gutter="0">
                  <el-col :span="12">
                    <el-form-item label="姓名">
                      <el-input v-model="healthaccess.username">
                        <!-- <template slot="append">cm</template> -->
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="身高">
                      <el-input v-model="healthaccess.height">
                        <template slot="append">cm</template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="0">
                  <el-col :span="12">
                    <el-form-item label="体重">
                      <el-input v-model="healthaccess.weight">
                        <template slot="append">kg</template>
                      </el-input>
                    </el-form-item></el-col
                  >
                  <el-col :span="12">
                    <el-form-item label="年龄">
                      <el-input v-model="healthaccess.age">
                        <!-- <template slot="append">kg</template> -->
                      </el-input>
                    </el-form-item></el-col
                  >
                </el-row>
                <el-row :gutter="0">
                  <el-col :span="12">
                    <el-form-item label="安静心率测试1" label-width="120px">
                      <el-input v-model="healthaccess.heartrate1">
                        <template slot="append">/min</template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="安静心率测试2" label-width="120px">
                      <el-input v-model="healthaccess.heartrate2">
                        <template slot="append">/min</template>
                      </el-input>
                    </el-form-item></el-col
                  >
                </el-row>
                <el-row :gutter="0">
                  <el-col :span="12">
                    <el-form-item label="俯卧撑数">
                      <el-input v-model="healthaccess.pushUp">
                        <template slot="append">/min</template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="引体向上">
                      <el-input v-model="healthaccess.pullUp">
                        <template slot="append">/min</template>
                      </el-input>
                    </el-form-item></el-col
                  >
                </el-row>
                <el-row :gutter="0">
                  <el-col :span="12">
                    <el-form-item label="仰卧起坐">
                      <el-input v-model="healthaccess.siteUp">
                        <template slot="append">/min</template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="配速">
                      <el-input v-model="healthaccess.rate">
                        <template slot="append">min/1km</template>
                      </el-input>
                    </el-form-item></el-col
                  >
                </el-row>
                <el-row :gutter="0">
                  <el-col :span="12">
                    <el-form-item label="饭前血糖">
                      <el-input v-model="healthaccess.bloodGlucose">
                        <template slot="append">mmol/L</template>
                      </el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="睡眠">
                      <el-input v-model="healthaccess.sleep">
                        <template slot="append">h</template>
                      </el-input>
                    </el-form-item></el-col
                  >
                </el-row>
                <el-form-item label="上周平均步数" label-width="100px">
                  <el-input v-model="healthaccess.stepNumber"> </el-input>
                </el-form-item>

                <el-form-item label="">
                  <el-checkbox-group v-model="healthaccess.typenameTemp">
                    <el-checkbox
                      v-for="item in type"
                      :label="item"
                      :key="item.id"
                      v-model="healthaccess.typenameTemp"
                    ></el-checkbox>
                  </el-checkbox-group>
                </el-form-item>
                <!-- <el-form-item>
                <el-button type="primary" @click="onSubmit">提交</el-button>
                <el-button @click="cancle">取消</el-button>
              </el-form-item> -->
              </el-form>
            </div>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="onSubmit">确 定</el-button>
            </span>
          </el-dialog>
          <el-dialog
            :visible.sync="dialogVisible2"
            width="80%"
            :before-close="handleClose"
          >
            <template slot="title">
              <div class="div2">{{ standardOne.name }}</div>
            </template>
            <el-row>
              <el-col :span="12"
                ><div><img class="image1" :src="standardOne.videoUrl" /></div
              ></el-col>
              <el-col :span="12">
                <el-form
                  :model="standardOne"
                  label-width="100px"
                  label-position="left"
                  style="padding-left: 40px;"
                >
                  <el-form-item label="名称" size="medium">
                    <!-- <el-input v-model="standardOne.name"></el-input> -->
                    {{ standardOne.name }}
                  </el-form-item>
                  <el-form-item label="建议运动时长" size="medium">
                    <!-- <el-input v-model="standardOne.name"></el-input> -->
                    {{ standardOne.sportsTime }}
                  </el-form-item>
                  <el-form-item label="建议运动频率" size="medium">
                    <!-- <el-input v-model="standardOne.name"></el-input> -->
                    {{ standardOne.sportsFrequency }}
                  </el-form-item>
                  <el-form-item label="注意事项" size="medium">
                    <!-- <el-input v-model="standardOne.name"></el-input> -->
                    {{ standardOne.notice }}
                  </el-form-item>

                  <!-- </el-form-item> -->
                </el-form></el-col
              >
            </el-row>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible2 = false">取 消</el-button>
              <el-button type="primary" @click="dialogVisible2 = false"
                >确 定</el-button
              >
            </span>
          </el-dialog>
        </div>
        <div v-else-if="page === 0">
          <dv-border-box-11 title="个人监控数据监控">
            <el-row>
              <el-col :span="6">
                <dv-decoration-8 style="width:300px;height:50px;" />
              </el-col>
              <el-col :span="12" style="margin-top: 22px;padding-left: 5%;">
                <dv-decoration-10 style="width:90%;height:5px;" />
              </el-col>
              <el-col :span="6">
                <dv-decoration-8
                  :reverse="true"
                  style="width:300px;height:50px;"
                />
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="11"
                ><dv-border-box-1
                  style="width:100%;height:180px;padding-left: 50px; padding-top: 18px; margin-left: 5%;background-color: rgb(40,44,52);"
                  ><Allscore></Allscore
                ></dv-border-box-1>
              </el-col>
              <el-col :span="2">&ensp;</el-col>
              <el-col :span="10">
                <dv-border-box-8
                  style="width:100%;height:180px;padding-left: 50px; padding-top: 18px; margin-left: 5%;background-color: rgb(40,44,52); "
                >
                  <!-- <p style="color: white;">评测分数</p> -->
                  <dv-decoration-9
                    style="width:140px;height:140px;  color: white; "
                    >{{ score }}分</dv-decoration-9
                  >
                </dv-border-box-8>
              </el-col>
            </el-row>

            <!-- <el-row>
              <el-col :span="12">
                <div>数据</div>
              </el-col>
            </el-row> -->
            <!-- <dv-border-box-7 dur="6"
              ><Heart></Heart> <Heart></Heart
            ></dv-border-box-7> -->
          </dv-border-box-11>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  data() {
    return {
      page: 1,
      iftest: 0,
      loading: true,
      currentDate: "",
      dialogVisible: false,
      dialogVisible2: false,
      score: "",
      isaccess: false,
      standard: [],
      standardOne: {},
      healthaccess: {
        username: "",
        height: "",
        weight: "",
        age: "",
        heartrate1: "",
        heartrate2: "",
        typename: "",
        pushUp: "", //俯卧撑
        pullUp: "", //引体向上
        siteUp: "", //仰卧起坐
        rate: "", //配速
        bloodGlucose: "", //饭前血糖
        sleep: "",
        stepNumber: "",
        typenameTemp: [],
      },
      type: [],
      selectedDiseases: [],
    };
  },
  created() {
    this.getDiseaseData();
    // this.accessscore();
    this.getNowTime();
    // this.selectStandard();
  },
  methods: {
    getDiseaseData() {
      this.$http
        .get(this.$config.baseUrl + "disease/diseaseAll")
        .then((response) => {
          console.log(response.data.data);
          this.type = response.data.data;
        });
    },
    access() {
      this.isaccess = true;
      this.dialogVisible = true;
    },
    cancle() {
      this.isaccess = false;
    },
    accessscore() {
      this.$http
        .get(
          this.$config.baseUrl +
            "healthaccess/sbrscore?username=" +
            localStorage.getItem("adminName")
        )
        .then((response) => {
          console.log(response.data.score);
          if (response.data.score != 0) {
            this.iftest = 1;
            this.score.value = response.data.score;
          }
        });
    },
    onSubmit() {
      this.dialogVisible = false;
      this.username = localStorage.getItem("adminName");
      this.healthaccess.typename = this.healthaccess.typenameTemp.join(",");
      console.log(JSON.stringify(this.healthaccess));
      this.$http
        .post(
          this.$config.baseUrl + "healthaccess/insertHealthAccess",
          this.healthaccess
        )
        .then((response) => {
          // this.score = response.data.score;
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // handleClose(done) {
    //   this.$confirm("确认关闭？")
    //     .then((_) => {
    //       done();
    //     })
    //     .catch((_) => {});
    // },
    watchdetail(index) {
      this.dialogVisible2 = true;
      this.standardOne = this.standard[index];
    },
    selectStandard() {
      this.$http
        .get(
          this.$config.baseUrl +
            "healthaccess/sbrscore?username=" +
            localStorage.getItem("adminName")
        )
        .then((response) => {
          if (response.data.score != 0) {
            this.iftest = 1;
            this.score = response.data.score;
            localStorage.setItem("score", response.data.score);
          }
          console.log(response.data.score);
        });
      this.$http
        .get(
          this.$config.baseUrl +
            "standard/standardRecipe?score=" +
            localStorage.getItem("score")
        )
        .then((response) => {
          // console.log(localStorage.getItem("score"));
          this.standard = response.data.standard;
          console.log(this.score);
          console.log(this.standard);
        });
    },
    //格式化时间格式
    getNowTime() {
      const yy = new Date().getFullYear();
      const MM =
        new Date().getMonth() + 1 < 10
          ? "0" + (new Date().getMonth() + 1)
          : new Date().getMonth() + 1;
      const dd =
        new Date().getDate() < 10
          ? "0" + new Date().getDate()
          : new Date().getDate();
      const HH =
        new Date().getHours() < 10
          ? "0" + new Date().getHours()
          : new Date().getHours();
      const mm =
        new Date().getMinutes() < 10
          ? "0" + new Date().getMinutes()
          : new Date().getMinutes();
      const ss =
        new Date().getSeconds() < 10
          ? "0" + new Date().getSeconds()
          : new Date().getSeconds();
      this.currentDate =
        yy + "-" + MM + "-" + dd + " " + HH + ":" + mm + ":" + ss;
    },
  },
  mounted() {
    this.selectStandard();
  },
};
</script>
<style>
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  height: 250px;
  display: block;
}
.image1 {
  width: 100%;
  height: 60vh;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}
</style>
