package com.splat.bms.service;

import com.splat.bms.model.Role;
import com.splat.bms.model.User;

import java.util.List;

public interface UserService {

    /**
     * Gets user by login and password
     *
     * @param login    string user login
     * @param password string user password
     * @return         user model
     */
    User getUserByLoginAndPassword(String login, String password);

    /**
     * Creates a new user and encrypts password
     *
     * @param login    string user login
     * @param password string password
     * @param roles    list of creating user roles
     * @return         created user id
     */
    int addUser(String login, String password, List<Role> roles);

}
