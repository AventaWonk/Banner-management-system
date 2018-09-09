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
     * @return         user model if exists
     */
    User findByLogin(String login);

    /**
     * Saves a new user into database and returns generated int id
     *
     * @param login    unique string user login
     * @param password string user password
     * @param date     Date of creation
     * @return         Created user id
     */
    int create(User user);

}
