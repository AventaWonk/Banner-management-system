package com.splat.bms.service.impl;

import com.splat.bms.model.AdminAction;
import com.splat.bms.service.AdminActionLoggingService;
import com.splat.bms.service.AdminActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DatabaseAdminAdminActionLoggingService implements AdminActionLoggingService {

    private AdminActionService adminActionService;

    /**
     * Saves a new admin action into database
     *
     * @param bannerId    int target banner id
     * @param adminId     int admin id
     * @param description string description of action
     */
    @Override
    public void log(int adminId, int bannerId, String description) {
        AdminAction adminAction = new AdminAction()
                .setAdminId(adminId)
                .setBannerId(bannerId)
                .setDescription(description)
                .setDate(new Date());

        this.adminActionService.addAdminAction(adminAction);
    }

    @Autowired
    public void setAdminActionService(AdminActionService adminActionService) {
        this.adminActionService = adminActionService;
    }
}
