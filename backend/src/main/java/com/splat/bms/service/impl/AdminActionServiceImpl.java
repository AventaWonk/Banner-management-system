package com.splat.bms.service.impl;

import com.splat.bms.dao.AdminActionDao;
import com.splat.bms.model.AdminAction;
import com.splat.bms.service.AdminActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminActionServiceImpl implements AdminActionService {

    private AdminActionDao adminActionDao;

    /**
     * Gets all existing admin actions
     *
     * @return List of admin actions
     */
    @Override
    public List<AdminAction> getAllAdminActions() {
        return this.adminActionDao.findAll();
    }

    /**
     * Gets all existing admin actions with specified admin id
     *
     * @param id of admin
     * @return List of admin actions
     */
    @Override
    public List<AdminAction> getAdminActionsByAdminId(int id) {
        return this.adminActionDao.findByAdminId(id);
    }

    /**
     * Gets all existing admin actions with specified banner id
     *
     * @param id of banner
     * @return List of admin actions
     */
    @Override
    public List<AdminAction> getAdminActionsByBannerId(int id) {
        return this.adminActionDao.findByBannerId(id);
    }

    /**
     * Adds a new admin action entity and return generated id
     *
     * @param adminAction new entity
     * @return created admin action id
     */
    @Override
    public int addAdminAction(AdminAction adminAction) {
        return this.adminActionDao.create(adminAction);
    }

    @Autowired
    public void setAdminActionDao(AdminActionDao adminActionDao) {
        this.adminActionDao = adminActionDao;
    }
}
