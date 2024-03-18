import VueRouter from "vue-router";

//引入组件
import Index from "../pages";
import Home from "../pages/home/home";
import Login from "../pages/login/login";
import Register from "../pages/register/register";
import Center from "../pages/center/center";
import News from "../pages/news/news-list";
import NewsDetail from "../pages/news/news-detail";
import yonghuList from "../pages/yonghu/list";
import yonghuDetail from "../pages/yonghu/detail";
import yonghuAdd from "../pages/yonghu/add";
import keshiList from "../pages/keshi/list";
import keshiDetail from "../pages/keshi/detail";
import keshiAdd from "../pages/keshi/add";
import yishengList from "../pages/yisheng/list";
import yishengDetail from "../pages/yisheng/detail";
import yishengAdd from "../pages/yisheng/add";
import VisitingDoctorList from "../pages/VisitingDoctor/list";
import VisitingDoctorDetail from "../pages/VisitingDoctor/detail";
import VisitingDoctorAdd from "../pages/VisitingDoctor/add";
import yuyueguahaoList from "../pages/yuyueguahao/list";
import yuyueguahaoDetail from "../pages/yuyueguahao/detail";
import yuyueguahaoAdd from "../pages/yuyueguahao/add";
import jiankangdanganList from "../pages/jiankangdangan/list";
import jiankangdanganDetail from "../pages/jiankangdangan/detail";
import jiankangdanganAdd from "../pages/jiankangdangan/add";
import jibingpingguList from "../pages/jibingpinggu/list";
import jibingpingguDetail from "../pages/jibingpinggu/detail";
import jibingpingguAdd from "../pages/jibingpinggu/add";
import healthindex from "../pages/healthmanage/index.vue";

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch((err) => err);
};

//配置路由
export default new VueRouter({
  routes: [
    {
      path: "/",
      redirect: "/index/home",
    },
    {
      path: "/index",
      component: Index,
      children: [
        {
          path: "home",
          component: Home,
        },
        {
          path: "center",
          component: Center,
        },
        {
          path: "healthindex",
          component: healthindex,
        },
        {
          path: "news",
          component: News,
        },
        {
          path: "newsDetail",
          component: NewsDetail,
        },
        {
          path: "yonghu",
          component: yonghuList,
        },
        {
          path: "yonghuDetail",
          component: yonghuDetail,
        },
        {
          path: "yonghuAdd",
          component: yonghuAdd,
        },
        {
          path: "keshi",
          component: keshiList,
        },
        {
          path: "keshiDetail",
          component: keshiDetail,
        },
        {
          path: "keshiAdd",
          component: keshiAdd,
        },
        {
          path: "yisheng",
          component: yishengList,
        },
        {
          path: "yishengDetail",
          component: yishengDetail,
        },
        {
          path: "yishengAdd",
          component: yishengAdd,
        },
        {
          path: "VisitingDoctor",
          component: VisitingDoctorList,
        },
        {
          path: "VisitingDoctorDetail",
          component: VisitingDoctorDetail,
        },
        {
          path: "VisitingDoctorAdd",
          component: VisitingDoctorAdd,
        },
        {
          path: "yuyueguahao",
          component: yuyueguahaoList,
        },
        {
          path: "yuyueguahaoDetail",
          component: yuyueguahaoDetail,
        },
        {
          path: "yuyueguahaoAdd",
          component: yuyueguahaoAdd,
        },
        {
          path: "jiankangdangan",
          component: jiankangdanganList,
        },
        {
          path: "jiankangdanganDetail",
          component: jiankangdanganDetail,
        },
        {
          path: "jiankangdanganAdd",
          component: jiankangdanganAdd,
        },
        {
          path: "jibingpinggu",
          component: jibingpingguList,
        },
        {
          path: "jibingpingguDetail",
          component: jibingpingguDetail,
        },
        {
          path: "jibingpingguAdd",
          component: jibingpingguAdd,
        },
      ],
    },
    {
      path: "/login",
      component: Login,
    },
    {
      path: "/register",
      component: Register,
    },
  ],
});
