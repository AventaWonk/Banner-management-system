<template>
    <div class="">
        <div class="row">
        <div class="col-md-6">
        <h2>{{initialData ? 'Update banner' : 'Create a new banner'}}</h2>
            <form @submit.prevent="handleSaveButtonClick">
                <div class="form-group" v-if="banner.id">
                    <label for="">Id</label>
                    <input type="text" id="id" class="form-control-plaintext"
                        v-model="banner.id">
                </div>
                <div class="form-group">
                    <label for="">Image source</label>
                    <input v-model="banner.imgSrc" type="text" class="form-control" id=""
                        :class="errors.imgSrc ? 'invalid-data' : ''">
                    <div class="invalid-message" v-if="errors.imgSrc">
                        Please provide a valid image source.
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Width</label>
                    <input v-model="banner.width"  type="text" class="form-control" id=""
                        :class="errors.width ? 'invalid-data' : ''">
                    <div class="invalid-message" v-if="errors.width">
                        Please provide a valid width.
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Height</label>
                    <input v-model="banner.height" type="text" class="form-control" id=""
                        :class="errors.height ? 'invalid-data' : ''">
                    <div class="invalid-message" v-if="errors.height">
                        Please provide a valid height.
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Target URL</label>
                    <input v-model="banner.targetUrl" type="text" class="form-control" id=""
                        :class="errors.targetUrl ? 'invalid-data' : ''">
                    <div class="invalid-message" v-if="errors.targetUrl">
                        Please provide a valid URL.
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Language Id</label>
                    <input v-model="banner.langId" type="text" class="form-control" id=""
                        :class="errors.langId ? 'invalid-data' : ''">
                    <div class="invalid-message" v-if="errors.langId">
                        Please provide a valid language id.
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" :class="isValid ? '' : 'disabled'">Save</button>
                <button type="button" class="btn btn-outline-primary">Cancel</button>
            </form>
        </div>
    </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator"
import Banner from "../../Interfaces/Banner";

@Component
export default class BannerForm extends Vue {

    @Prop() initialData!: Banner;
    @Prop() onSave: (banner: Banner) => void;

    private banner: Banner;
    private isValid: boolean = false;
    private errors = {};

    constructor() {
        super();
        const initialBanner = {
            id: null,
            imgSrc: '',
            width: 0,
            height: 0,
            targetUrl: '',
            langId: 0,
        }
        
        this.banner = {...this.initialData ? this.initialData : initialBanner}; 
    }

    handleSaveButtonClick(): void {
        this.onSave(this.banner);
    }

};
</script>
