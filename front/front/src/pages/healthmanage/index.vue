<template>
  <div>
    <el-row>
      <el-col :span="4">
        <div class="div1"><LeftBat></LeftBat></div
      ></el-col>
      <el-col :span="20">
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
        <div class="card" v-if="iftest === 0">
          <h2><strong>处方评测</strong> 简介</h2>
          <div>
            <small
              >由于您完成<strong>个人体制评测</strong>，所以暂未为您生成运动处方，如果想要获得合适的运动处方，请您尽快完成相关评测</small
            >
          </div>
          <div>
            <el-button round class="m-t-5" type="text">立即测评</el-button>
          </div>
        </div>
        <div class="card m-t-5">
          <h2
            style="color: rgb(86,156,203); font-size: 40px; text-align: center;"
          >
            体制测评(填写数据越全越精准)
          </h2>
          <el-form ref="form" :model="healthaccess" label-width="80px">
            <el-row :gutter="0">
              <el-col :span="12">
                <el-form-item label="用户名">
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
            <el-form-item>
              <el-button type="primary" @click="onSubmit">提交</el-button>
              <el-button>取消</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  data() {
    return {
      iftest: 0,
      dialogVisible: false,
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
      localStorage.getItem("adminName");

      this.$http
        .get(this.$config.baseUrl + "healthaccess/sbrscore")
        .then((response) => {
          console.log(response);
        });
    },
    onSubmit() {
      this.healthaccess.typename = this.healthaccess.typenameTemp.join(",");
      console.log(JSON.stringify(this.healthaccess));
      this.$http
        .post(
          this.$config.baseUrl + "healthaccess/insertHealthAccess",
          this.healthaccess
        )
        .then((response) =>