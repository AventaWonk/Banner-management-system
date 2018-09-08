package com.splat.bms.model;

import java.util.Date;

public class AdminAction {

    private int id;
    private int bannerId;
    private int adminId;
    private String description;
    private Date date;

    public int getId() {
        return id;
    }

    public AdminAction setId(int id) {
        this.id = id;
        return this;
    }

    public int getBannerId() {
        return bannerId;
    }

    public AdminAction setBannerId(int bannerId) {
        this.bannerId = bannerId;
        return this;
    }

    public int getAdminId() {
        return adminId;
    }

    public AdminAction setAdminId(int adminId) {
        this.adminId = adminId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AdminAction setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public AdminAction setDate(Date date) {
        this.date = date;
        return this;
    }
}
