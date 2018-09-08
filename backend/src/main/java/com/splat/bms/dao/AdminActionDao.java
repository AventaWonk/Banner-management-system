package com.splat.bms.dao;

import com.splat.bms.model.AdminAction;

import java.util.List;

public interface AdminActionDao {

    /**
     * Returns all existing adminActions in db with specified banner id
     *
     * @param id of target banner
     * @return   list of adminActions
     */
    List<AdminAction> findByBannerId(int id);

    /**
     * Returns all existing adminActions in db with specified admin id
     *
     * @param id of admin
     * @return   list of adminActions
     */
    List<AdminAction> findByAdminId(int id);

    /**
     * Returns all existing adminActions contained in database
     *
     * @return list of all adminAction
     */
    List<AdminAction> findAll();

    /**
     * Adds a new adminAction into database
     *
     * @param adminAction new adminAction record data
     * @return            inserted adminAction record id
     */
    int create(AdminAction adminAction);

    /**
     * Updates existing adminAction record in database
     *
     * @param adminAction updated adminAction data
     */
    void update(AdminAction adminAction);

    /**
     * Removes existing adminAction record in database
     *
     * @param id of removing adminAction
     */
    void remove(int id);

}
