<!-- src/components/Hello.vue -->
<template>
  <div>
    <button type="button" class="btn btn-outline-primary mb-2">Create a new banner</button>
    <table class="table">
    <thead>
      <tr>
        <th class="sortable" 
          v-for="row in rows" 
          v-bind:key="row"
          @click="sortBy(row.key)" 
          :class="sortedColumnKey === row.key ? 'border-bottom border-primary' : ''">
          {{ row.title }}
          <i class="control fas fa-xs"
            :class="sortedColumnKey === row.key && sortingOrder === 1 ? 'fa-chevron-down' : 'fa-chevron-up'">
          </i>
        </th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="banner in banners" v-bind:key="banner">
        <td>{{ banner.id }}</td>
        <td>{{ banner.imgSrc }}</td>
        <td>{{ banner.width }}</td>
        <td>{{ banner.height }}</td>
        <td>{{ banner.targetUrl }}</td>
        <td>{{ banner.langId }}</td>
        <td class="side-control-row">
          <i class="control side-control fas fa-lg fa-pen" @click="editBanner(banner)"></i>
          <i class="control side-control  fas fa-lg fa-times" @click="removeBanner(banner.id)"></i>
        </td>
      </tr>
    </tbody>
  </table>
  </div>
  
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";
import Banner from "../Interfaces/Banner";

enum Order {
  ASCENDING = 1,
  DESCENDIN = -1
}

interface Row {
  title: string;
  key: string;
}

const DEFAULT_SORTING_ORDER = Order.ASCENDING;

const rows = [
  {
    title: 'Id',
    key: 'id'
  },
  {
    title: 'Image source',
    key: 'imgSrc'
  },
  {
    title: 'Width',
    key: 'width'
  },
  {
    title: 'Height',
    key: 'height'
  },
  {
    title: 'Target URL',
    key: 'targetUrl'
  },
  {
    title: 'Language Id',
    key: 'langId'
  },
];

const banners = [
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
]

@Component
export default class Admin extends Vue {

  private rows: Row[];
  private banners: Banner[];
  private sortingOrder: Order;
  private sortedColumnKey: string;

  constructor() {
    super();
    this.rows = rows;
    this.banners = banners;
    this.sortingOrder = DEFAULT_SORTING_ORDER;
    this.sortedColumnKey = '';
  }

  public sortBy (key: string): void {
    if (key == this.sortedColumnKey) {
      this.sortingOrder = this.sortingOrder == Order.ASCENDING ? Order.DESCENDIN : Order.ASCENDING;
    } else {
      this.sortingOrder = DEFAULT_SORTING_ORDER;
    }

    let order: number = this.sortingOrder;
    let comparator = function (a: any, b: any): number  {
      let value1 = a[key];
      let value2 = b[key];

      return (value1 === value2 ? 0 : value1 > value2 ? 1 : -1) * order;
    }

    this.banners.sort(comparator);
    this.sortedColumnKey = key;
  };

  public createBanner (): void {
    let initBanner = {
      id: '',
      imgSrc: '',
      width: '',
      height: '',
      targetUrl: '',
      langId: ''
    }
  };

  public removeBanner (id: number): void {
    for (let i = 0; i < this.banners.length; i++) {
      if (this.banners[i].id == id) {
        this.banners.splice(i, 1);
      }
    };

    $.post("ajax/test.html", {})
      .done(response => {
        alert(response);
      })
      .fail( fail => {

      });
  };

  public editBanner (id: number): void {

  };

};
</script>
