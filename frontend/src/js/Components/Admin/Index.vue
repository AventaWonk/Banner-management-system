<template>
  <div>
    <BannerForm v-if="isFormOpen" :initialData="banner" 
      :onSave="handleSave"
      />
    <button type="button" class="btn btn-outline-primary mb-2" @click="handleCreate">
      Create a new banner
    </button>
    <BannersTable :onEdit="handleEdit" :onRemove="handleRemove" :banners="banners" />
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";
import BannerForm from "./BannerForm.vue"
import BannersTable from "./BannersTable.vue";
import Banner from "../../Interfaces/Banner";

const banners: Banner[] = [
  {
    id: 1,
    imgSrc: "img1",
    width: 12,
    height: 22,
    targetUrl: "number",
    langId: 1
  },
  {
    id: 2,
    imgSrc: "img2",
    width: 121,
    height: 12,
    targetUrl: "number",
    langId: 1
  },
  {
    id: 3,
    imgSrc: "img3",
    width: 92,
    height: 32,
    targetUrl: "number",
    langId: 1
  },
  {
    id: 3,
    imgSrc: "img3",
    width: 92,
    height: 32,
    targetUrl: "number",
    langId: 1
  },
  {
    id: 3,
    imgSrc: "img3",
    width: 92,
    height: 32,
    targetUrl: "number",
    langId: 1
  },
  {
    id: 3,
    imgSrc: "img3",
    width: 92,
    height: 32,
    targetUrl: "number",
    langId: 1
  },
  {
    id: 3,
    imgSrc: "img3",
    width: 92,
    height: 32,
    targetUrl: "number",
    langId: 1
  },
]; 

@Component({
  components: {
    BannerForm,
    BannersTable
  }
})
export default class Index extends Vue {

  private banners: Banner[] = banners;
  private isFormOpen: boolean = false;
  public banner: Banner;

  constructor() {
    super();
  }

  handleEdit(banner: Banner) {
    this.isFormOpen = true;
    this.banner = banner;
    
  }

  handleSave(banner: Banner) {
    this.isFormOpen = false;
    if(banner.id) {
      this.updateBanner(banner);
      return;
    }

    this.saveBanner(banner)
  }

  handleCreate() {
    this.banner = null;
    this.isFormOpen = true;
  }

  handleRemove(id) {
    try {
      let index = this.getBannerIndexById(id);
      this.banners.splice(index, 1);
    } catch (e) {
      console.error(e);
    }

    // $.post("", {})
    //   .done(response => {
    //   })
    //   .fail( fail => {

    //   });
  }

  saveBanner(banner: Banner) {
    this.banners.push(banner);
    // $.post("ajax/test.html", {})
    //   .done(response => {
    //   })
    //   .fail( fail => {

    //   });
  }

  updateBanner(banner: Banner) {
    try {
      let index = this.getBannerIndexById(banner.id);
      let newBannersState = [...banners];
      newBannersState[index] = banner;
      this.banners = newBannersState;
    } catch (e) {
      console.error(e);
    }

    // $.post("", {})
    //   .done(response => {
    //     alert(response);
    //   })
    //   .fail( fail => {

    //   });
  }

  getBannerIndexById(id): number {
    for (let i = 0; i < this.banners.length; i++) {
      if (this.banners[i].id == id) {
        return i;
      }
    };

    throw new Error("Cant find index at banners array");
  }

};
</script>
