package com.splat.bms.service;

import com.splat.bms.model.Role;

import java.util.List;

public interface RoleService {

    /**
     * Gets user roles by user id
     *
     * @param id user id
     * @return   List of user roles
     */
    List<Role> getRolesByUserId(int id);

}
