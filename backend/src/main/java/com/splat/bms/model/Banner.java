package com.splat.bms.model;

public class Banner {

    private int id;
    private String imgSrc;
    private int width;
    private int height;
    private String targetUrl;
    private int langId;

    public int getId() {
        return id;
    }

    public Banner setId(int id) {
        this.id = id;
        return this;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public Banner setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Banner setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Banner setHeight(int height) {
        this.height = height;
        return this;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public Banner setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
        return this;
    }

    public int getLangId() {
        return langId;
    }

    public Banner setLangId(int langId) {
        this.langId = langId;
        return this;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", imgSrc='" + imgSrc + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", targetUrl='" + targetUrl + '\'' +
                ", langId=" + langId +
                '}';
    }
}
