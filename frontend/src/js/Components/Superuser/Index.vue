<template>
  <div class="row">
    <div class="col-md">
    <form @submit.prevent="searchById" class="form-inline mb-2">
      <label for="" class="mx-2">Search by</label>
      <select class="form-control" id="" v-model="idType">
        <option>Banner Id</option>
        <option>Admin Id</option>
      </select>
      <input v-model="id" type="text" class="form-control mx-2" id="" placeholder="Banner or admin id" >
      <button type="submit" class="btn btn-outline-primary">Search</button>
    </form>
    </div>

    <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Banner Id</th>
        <th>Admin Id</th>
        <th>Description</th>
        <th>Date</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="action in actions" :key="action.id">
        <td>{{ action.id }}</td>
        <td>{{ action.bannerId }}</td>
        <td>{{ action.adminId }}</td>
        <td>{{ action.description }}</td>
        <td>{{ action.date }}</td>
      </tr>
    </tbody>
  </table>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";
import AdminAction from "../../Interfaces/AdminAction";

enum idType {
  BANNER_ID = 'Banner Id',
  ADMIN_ID = 'Admin Id'
}

const testAcions: AdminAction[] = [
  {
    id: 1,
    bannerId: 3,
    adminId: 1,
    description: 'test1',
    date: new Date(),
  },
  {
    id: 2,
    bannerId: 2,
    adminId: 4,
    description: 'test2',
    date: new Date(),
  },
  {
    id: 3,
    bannerId: 2,
    adminId: 4,
    description: 'test3',
    date: new Date(),
  }
]

@Component
export default class Superuser extends Vue {

    private actions: AdminAction[];
    private id = '';
    private idType: string = idType.ADMIN_ID;

    constructor() {
        super();
        this.actions = testAcions;
    }

    private searchByBannerId (id:number): void {
        //getActionsByBannerId
    };

    private searchByAdminId (id:number): void {
        //getActionByAdminId
    };

}
</script>
