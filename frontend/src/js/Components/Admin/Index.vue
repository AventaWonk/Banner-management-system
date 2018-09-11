<template>
  <div>
    <BannerForm v-if="isFormOpen" :initialBanner="banner" 
      :onSave="onSave"
      :onCancel="onCancel"
      />
    <button type="button" class="btn btn-outline-primary mb-2 ml-4" @click="handleCreateButtonClick">
      Create a new banner
    </button>
    <BannersTable :onEdit="onEdit" :onRemove="onRemove" :banners="banners" />
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";
import { getBanners } from "../../Service/Api";
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

  private banners: Banner[] = [];
  private isFormOpen: boolean = false;
  private banner: Banner;

  mounted() {
    // $.post( "api/banners/get", data => {
    //   if (data.status == "success") {
    //     this.banners = data.result
    //   }
    // }).fail(() => {
    //   alert("Can't connect to server");
    // })
  }

  public handleCreateButtonClick() {
    this.banner = null;
    this.openFrom();
  }

  public onEdit(banner: Banner) {
    this.banner = banner;
    this.openFrom();
  }

  public onRemove(id) {
    $.post( "api/banners/remove/"+ id, data => {
      if (data.status != "success") {
        alert('')
      }
    })

    try {
      let index = this.getBannerIndexById(id);
      this.banners.splice(index, 1);
    } catch (e) {
      console.error(e);
    }
  }


  public onSave(banner: Banner) {
    this.closeFrom();
    if(banner.id) {
      this.updateBanner(banner);
      return;
    }

    this.saveBanner(banner);
  }

  public onCancel(): void {
    this.closeFrom();
  }

  private saveBanner(banner: Banner): void {
    $.post( "api/banners/create", banner, data => {
      if (data.status == "success") {
        console.log(data.result)
      } else {
        console.error(data.result)
      }
    })
    
    this.banners.push(banner);
  }

  private updateBanner(banner: Banner): void {
    try {
        let index = this.getBannerIndexById(banner.id);
        let newBannersState = [...banners];
        newBannersState[index] = banner;
        this.banners = newBannersState;
      } catch (e) {
        console.error(e);
      }
  }

  private openFrom(): void {
    this.isFormOpen = true;
  }

  private closeFrom(): void {
    this.isFormOpen = false;
  }

  private getBannerIndexById(id): number {
    for (let i = 0; i < this.banners.length; i++) {
      if (this.banners[i].id == id) {
        return i;
      }
    };

    throw new Error("Cant find index at banners array");
  }

};
</script>
