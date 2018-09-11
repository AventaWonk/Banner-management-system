<template>
    <div class="modal">
        <div class="modal-dialog">
            <div class="modal-header">
                 <h2>{{ initialBanner ? 'Update banner' : 'Create a new banner' }}</h2>
                <button type="button" class="close" aria-label="Close" @click="handleCancelButtonClick">
                    <span aria-hidden="true">&times;</span>
                 </button>
       
            </div>
        <div class="modal-content">
            
        
            <form @submit.prevent="handleSaveButtonClick" @change="handleChangeEvent">
                <div class="form-group" v-if="initialBanner && initialBanner.id">
                    <label for="">Id</label>
                    <input type="text" id="id" class="form-control-plaintext"
                        v-model.lazy="formBannerData.id">
                </div>
                <div class="form-group">
                    <label for="">Image source</label>
                    <input v-model.lazy="formBannerData.imgSrc" type="text" class="form-control" id=""
                        :class="errors.imgSrc ? 'invalid-data' : ''">
                    <div class="invalid-message" v-if="errors.imgSrc">
                        Please provide a valid image source.
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Width</label>
                    <input v-model.lazy="formBannerData.width"  type="text" class="form-control" id=""
                        :class="errors.width ? 'invalid-data' : ''">
                    <div class="invalid-message" v-if="errors.width">
                        Please provide a valid width.
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Height</label>
                    <input v-model.lazy="formBannerData.height" type="text" class="form-control" id=""
                        :class="errors.height ? 'invalid-data' : ''">
                    <div class="invalid-message" v-if="errors.height">
                        Please provide a valid height.
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Target URL</label>
                    <input v-model.lazy="formBannerData.targetUrl" type="text" class="form-control" id=""
                        :class="errors.targetUrl ? 'invalid-data' : ''">
                    <div class="invalid-message" v-if="errors.targetUrl">
                        Please provide a valid URL.
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Language Id</label>
                    <input v-model.lazy="formBannerData.langId" type="text" class="form-control" id=""
                        :class="errors.langId ? 'invalid-data' : ''">
                    <div class="invalid-message" v-if="errors.langId">
                        Please provide a valid language id.
                    </div>
                </div>
                <button type="submit" class="btn btn-primary ml-2" :class="isValid ? '' : 'disabled'">Save</button>
                <button type="button" class="btn btn-outline-primary float-right mr-2" 
                    @click="handleCancelButtonClick">Cancel</button>
                
            </form>
        </div>
    </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";
import { validationRules } from "../../Service/ValidationRules";
import Banner from "../../Interfaces/Banner";

interface FormBannerData {
    imgSrc: string;
    width: string;
    height: string;
    targetUrl: string;
    langId: string;
}

@Component
export default class BannerForm extends Vue {

    @Prop() initialBanner?: Banner;
    @Prop() onSave: (banner: Banner) => void;
    @Prop() onCancel: () => void;

    private formBannerData: FormBannerData = {
        imgSrc: '',
        width: '',
        height: '',
        targetUrl: '',
        langId: '',
    };
    private isValid: boolean = false;
    private errors = {};

    constructor() {
        super();
        
        if (this.initialBanner) {
            this.isValid = true;
            this.formBannerData = {
                imgSrc: this.initialBanner.imgSrc,
                width: this.initialBanner.width.toString(),
                height: this.initialBanner.height.toString(),
                targetUrl: this.initialBanner.targetUrl,
                langId: this.initialBanner.langId.toString(),
            }
        }
        let div = document.createElement("div");
        div.className = " modal-backdrop fade show";
        document.body.appendChild(div)
    }

    public handleSaveButtonClick(): void {
        let banner: Banner = {
            id: this.initialBanner.id,
            imgSrc: this.formBannerData.imgSrc,
            width: parseInt(this.formBannerData.width),
            height: parseInt(this.formBannerData.height),
            targetUrl: this.formBannerData.targetUrl,
            langId: parseInt(this.formBannerData.langId),
        }
        this.onSave(banner);
    }

    public handleChangeEvent(): void {
        this.isValid = true;
        this.validate();
    }

    public handleCancelButtonClick(): void {
        document.body.removeChild(document.body.lastChild);
        this.onCancel();
    }

    // private hasBannerBeenUpdated() {
    //     for (let field in this.formBannerData) {
    //         if (this.formBannerData[field] != this.initialBanner) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    private validate() {
        this.errors = {...this.errors};
        for (let field in this.formBannerData) {
            if (this.formBannerData[field].match(validationRules[field])) {
                this.errors[field] = false;
            } else {
                this.errors[field] = true;
            }
        }
    }

};
</script>
