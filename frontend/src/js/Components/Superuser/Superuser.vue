<!-- src/components/Hello.vue -->
<template>

  <div>
    <div class="row justify-content-center">
    <div class="col-md-6">
      <h1>Superuser panel</h1>
    </div>
    <form @submit.prevent="searchById" class="form-inline">
      <div class="form-group mb-2">
        <label for="">Search by</label>
        <select class="form-control" id="">
          <option>Banner Id</option>
          <option>Admin Id</option>
        </select>
      </div>
      <div class="form-group mb-2 mx-sm-3">
        <input v-model="bannerId" type="text" class="form-control" id="" placeholder="Banner or admin id" >
      </div>
      
      <button type="submit" class="btn btn-outline-primary mb-2">Search</button>
    </form>
    </div>
    <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Banner Id</th>
        <th>Description</th>
        <th>Date</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="action in actions" v-bind:key="action">
        <td>{{ action.id }}</td>
        <td>{{ action.bannerId }}</td>
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

@Component
export default class Superuser extends Vue {

    private actions: AdminAction[];
    private bannerId = '';

    constructor() {
        super();
        this.actions = [];
    }

    public searchByBannerId (id:number): void {
        //getActionsByBannerId
    };

    public searchByAdminId (id:number): void {
        //getActionByAdminId
    };

}
</script>
