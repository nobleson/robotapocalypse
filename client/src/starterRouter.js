import Vue from "vue";
import Router from "vue-router";

import Header from "./layout/starter/StarterHeader";
import AdminHeader from "./layout/starter/AdminHeader";
import Footer from "./layout/starter/StarterFooter";
import Starter from "./views/Starter.vue";
import Location from "./views/NewLocation.vue";
import ManageSurvivors from "./views/ManageSurvivors.vue";
import RegisterSurvivor from "./views/RegisterSurvivor.vue";
import Report from "./views/Report.vue";


Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: "/",
      name: "starter",
      components: {
        header: Header,
        default: Starter,
        footer: Footer
      }
    },
    {
      path: "/report",
      name: "report",
      components: {
        header: Header,
        default: Report,
        footer: Footer
      }
    },
    {
      path: "/newlocation",
      name: "location",
      components: {
        header: Header,
        default: Location,
        footer: Footer
      }
    },
    {
      path: "/manage",
      name: "manage",
      components: {
        header: AdminHeader,
        default: ManageSurvivors,
        footer: Footer
      }
    },
    {
      path: "/register",
      name: "register",
      components: {
        header: Header,
        default: RegisterSurvivor,
        footer: Footer
      }
    },
  ]
});
