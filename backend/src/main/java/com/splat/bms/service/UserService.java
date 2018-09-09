package com.splat.bms.service;

import com.splat.bms.model.Role;
import com.splat.bms.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    /**
     * Gets user by login and password
     *
     * @param login    string user login
     * @param password string user password
     * @return         user model
     */
    User getUser(String login, String password);

    User getUserByLogin(String login);


    /**
     * Creates a new user and encrypts password
     *
     * @param login    string user login
     * @param password string password
     * @param roles    list of creating user roles
     * @return         created user id
     */
    int addUser(User user);

}
