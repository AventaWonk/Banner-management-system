package com.splat.bms.service;

import com.splat.bms.model.AdminAction;

import java.util.List;

public interface AdminActionService {

    /**
     * Gets all existing admin actions
     *
     * @return List of admin actions
     */
    List<AdminAction> getAllAdminActions();

    /**
     * Gets all existing admin actions with specified admin id
     *
     * @param id of admin
     * @return   List of collected admin actions
     */
    List<AdminAction> getAdminActionsByAdminId(int id);

    /**
     * Gets all existing admin actions with specified banner id
     *
     * @param id of banner
     * @return   List of collected admin actions
     */
    List<AdminAction> getAdminActionsByBannerId(int id);

    /**
     * Adds a new admin action entity and return generated id
     *
     * @param adminAction new admin action entity
     * @return            created admin action int id
     */
    int addAdminAction(AdminAction adminAction);

}
