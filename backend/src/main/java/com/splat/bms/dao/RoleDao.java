package com.splat.bms.dao;

import com.splat.bms.model.Role;

import java.util.List;

public interface RoleDao {

    /**
     * Gets user roles by user id
     *
     * @param id user id
     * @return   List of user roles
     */
    List<Role> findByUserId(int id);

    /**
     * @param userId
     * @param roleId
     */
    void addRoleToUser(int userId, int roleId);

    /**
     * Creates new user role
     *
     * @param role new user role
     * @return     inserted row id
     */
    int create(Role role);

}
