const menu = {
  list() {
    return [
      {
        backMenu: [
          {
            child: [
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "用户",
                menuJump: "列表",
                tableName: "yonghu",
              },
            ],
            menu: "用户管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-discover",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "科室",
                menuJump: "列表",
                tableName: "keshi",
              },
            ],
            menu: "科室管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-qrcode",
                buttons: [
                  "新增",
                  "查看",
                  "修改",
                  "删除",
                  "科室医生统计",
                  "导入",
                ],
                menu: "医生",
                menuJump: "列表",
                tableName: "yisheng",
              },
            ],
            menu: "医生管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-album",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "出诊医生",
                menuJump: "列表",
                tableName: "VisitingDoctor",
              },
            ],
            menu: "出诊医生管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-taxi",
                buttons: ["查看", "修改", "删除"],
                menu: "预约挂号",
                menuJump: "列表",
                tableName: "yuyueguahao",
              },
            ],
            menu: "预约挂号管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-time",
                buttons: ["查看", "修改", "删除"],
                menu: "健康档案",
                menuJump: "列表",
                tableName: "jiankangdangan",
              },
            ],
            menu: "健康档案管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-addressbook",
                buttons: ["查看", "修改", "删除"],
                menu: "疾病评估",
                menuJump: "列表",
                tableName: "jibingpinggu",
              },
            ],
            menu: "疾病评估管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-pic",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "轮播图管理",
                tableName: "config",
              },
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "健康知识",
                tableName: "news",
              },
            ],
            menu: "系统管理",
          },
        ],
        frontMenu: [
          {
            child: [
              {
                appFrontIcon: "cuIcon-list",
                buttons: ["查看", "预约挂号"],
                menu: "出诊医生列表",
                menuJump: "列表",
                tableName: "VisitingDoctor",
              },
            ],
            menu: "出诊医生模块",
          },
        ],
        hasBackLogin: "是",
        hasBackRegister: "否",
        hasFrontLogin: "否",
        hasFrontRegister: "否",
        roleName: "管理员",
        tableName: "users",
      },
      {
        backMenu: [
          {
            child: [
              {
                appFrontIcon: "cuIcon-taxi",
                buttons: ["查看", "支付"],
                menu: "预约挂号",
                menuJump: "列表",
                tableName: "yuyueguahao",
              },
            ],
            menu: "预约挂号管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-time",
                buttons: ["查看"],
                menu: "健康档案",
                menuJump: "列表",
                tableName: "jiankangdangan",
              },
            ],
            menu: "健康档案管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-addressbook",
                buttons: ["查看"],
                menu: "疾病评估",
                menuJump: "列表",
                tableName: "jibingpinggu",
              },
            ],
            menu: "疾病评估管理",
          },
        ],
        frontMenu: [
          {
            child: [
              {
                appFrontIcon: "cuIcon-list",
                buttons: ["查看", "预约挂号"],
                menu: "出诊医生列表",
                menuJump: "列表",
                tableName: "VisitingDoctor",
              },
            ],
            menu: "出诊医生模块",
          },
        ],
        hasBackLogin: "是",
        hasBackRegister: "否",
        hasFrontLogin: "是",
        hasFrontRegister: "是",
        roleName: "用户",
        tableName: "yonghu",
      },
      {
        backMenu: [
          {
            child: [
              {
                appFrontIcon: "cuIcon-album",
                buttons: ["查看"],
                menu: "出诊医生",
                menuJump: "列表",
                tableName: "VisitingDoctor",
              },
            ],
            menu: "出诊医生管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-taxi",
                buttons: ["查看", "审核", "档案录入"],
                menu: "预约挂号",
                menuJump: "列表",
                tableName: "yuyueguahao",
              },
            ],
            menu: "预约挂号管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-time",
                buttons: ["查看", "修改", "疾病评估"],
                menu: "健康档案",
                menuJump: "列表",
                tableName: "jiankangdangan",
              },
            ],
            menu: "健康档案管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-addressbook",
                buttons: ["查看", "修改"],
                menu: "疾病评估",
                menuJump: "列表",
                tableName: "jibingpinggu",
              },
            ],
            menu: "疾病评估管理",
          },
        ],
        frontMenu: [
          {
            child: [
              {
                appFrontIcon: "cuIcon-list",
                buttons: ["查看", "预约挂号"],
                menu: "出诊医生列表",
                menuJump: "列表",
                tableName: "VisitingDoctor",
              },
            ],
            menu: "出诊医生模块",
          },
        ],
        hasBackLogin: "是",
        hasBackRegister: "否",
        hasFrontLogin: "否",
        hasFrontRegister: "否",
        roleName: "医生",
        tableName: "yisheng",
      },
    ];
  },
};
export default menu;
