import Vue from "vue";
import Index from "./Components/Admin/Index.vue";
import "../less/styles.less";

let v = new Vue({
    el: "#app",
    template: `
      <div>
        <Index />
      </div>
    `,
    components: {
        Index,
    }
});
