<template>
    <div class="row justify-content-center">
        <div class="col-md-6">
        <h1>Superuser panel</h1>
            <form @submit.prevent="searchByBannerId">
                <div class="form-group">
                    <label for="">Image source</label>
                    <input v-model="banner.imgSrc" type="text" class="form-control" id="" >
                </div>
                
                <button type="submit" class="btn btn-outline-primary">Search</button>
            </form>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator"
import AdminAction from "../../Interfaces/AdminAction";

@Component
export default class SuperuserIndex extends Vue {

    private actions: AdminAction[];

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
    
};
</script>
