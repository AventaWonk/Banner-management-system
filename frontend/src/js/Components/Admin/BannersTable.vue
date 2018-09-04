<!-- src/components/Hello.vue -->
<template>
  <table class="table">
    <thead>
      <tr>
        <th class="sortable" 
          v-for="(row, index) in rows" :key="index"
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
      <tr v-for="(banner, index) in banners" :key="index">
        <td>{{ banner.id }}</td>
        <td>{{ banner.imgSrc }}</td>
        <td>{{ banner.width }}</td>
        <td>{{ banner.height }}</td>
        <td>{{ banner.targetUrl }}</td>
        <td>{{ banner.langId }}</td>
        <td class="side-control-row">
          <i class="control side-control fas fa-lg fa-pen" @click="onEdit(banner)"></i>
          <i class="control side-control  fas fa-lg fa-times" @click="onRemove(banner.id)"></i>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";
import { Order, DEFAULT_SORTING_ORDER, BANNERS_TABLE_ROWS } from "../../Constants/Global";
import Banner from "../../Interfaces/Banner";

interface Row {
  title: string;
  key: string;
}

@Component
export default class BannersTable extends Vue {

  @Prop() banners: Banner[];
  @Prop() onEdit: (banner: Banner) => void;
  @Prop() onRemove: (id: number) => void;

  private rows: Row[];
  private sortingOrder: Order;
  private sortedColumnKey: string;

  constructor() {
    super();
    this.rows = BANNERS_TABLE_ROWS;
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

};
</script>
