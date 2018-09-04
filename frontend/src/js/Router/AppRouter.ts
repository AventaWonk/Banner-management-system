import Vue from "vue";
import VueRouter from "vue-router";

import Admin from "../";
import Superuser from "../";

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      path: "/admin",
      component: Admin
    },
    {
      path: "/superuser",
      component: Superuser
    }
  ],
  mode: "hash",
  linkActiveClass: "active"
});