package com.splat.bms.service.impl;

import com.splat.bms.dao.RoleDao;
import com.splat.bms.dao.UserDao;
import com.splat.bms.model.Role;
import com.splat.bms.model.User;
import com.splat.bms.service.RoleService;
import com.splat.bms.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;

    /**
     * Gets user by login and password
     *
     * @param login    string user login
     * @param password string user password
     * @return user model
     */
    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        return this.userDao.findByLoginAndPassword(login, passwordEncoder.encode(password));
    }

    /**
     * Creates a new user and encrypts password
     *
     * @param login    string user login
     * @param password string password
     * @param roles    list of creating user roles
     * @return created user id
     */
    @Override
    public int addUser(String login, String password, List<Role> roles) {
        return this.userDao.create(login, password, roles);
    }
}
