package com.splat.bms.dao;

import com.splat.bms.model.Role;
import com.splat.bms.model.User;

import java.util.Date;
import java.util.List;

public interface UserDao {

    /**
     * Returns existing user model by login an password
     *
     * @param login    unique string user login
     * @param password string user password
     * @return         user model if exists
     */
    User findByLoginAndPassword(String login, String password);

    /**
     * Saves a new user into database and returns generated int id
     *
     * @param login    unique string user login
     * @param password string user password
     * @param roles    List of user roles
     * @param date     Date of creation
     * @return         Created user id
     */
    int create(String login, String password, List<Role> roles , Date date);

}
