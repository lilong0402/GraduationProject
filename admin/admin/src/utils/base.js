const base = {
  get() {
    return {
      url: "http://localhost:8080/healthmanage/",
      name: "healthmanage",
      // 退出到首页链接
      indexUrl: "http://localhost:8080/healthmanage/front/dist/index.html",
    };
  },
  getProjectName() {
    return {
      projectName: "基于BS架构的个人健康管理系统的设计与实现",
    };
  },
};
export default base;
