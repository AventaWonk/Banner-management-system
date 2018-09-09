package com.splat.bms.service.impl;

import com.splat.bms.dao.RoleDao;
import com.splat.bms.dao.UserDao;
import com.splat.bms.model.Role;
import com.splat.bms.model.User;
import com.splat.bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Gets user by login and password
     *
     * @param login    string user login
     * @param password string user password
     * @return user model
     */
    @Override
    public User getUser(String login, String password) {
        User user = this.userDao.findByLogin(login);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return null;
        }

        user.setRoles(this.roleDao.findByUserId(user.getId()));

        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = this.userDao.findByLogin(login);
        if (user == null) {
            return null;
        }

        user.setRoles(this.roleDao.findByUserId(user.getId()));

        return user;
    }

    /**
     * Creates a new user and encrypts password
     *
     * @param
     * @return created user id
     */
    @Override
    public int addUser(User user) {
        user
                .setCreationDate(new Date())
                .setPassword(this.passwordEncoder.encode(user.getPassword()))
                .setEnabled(true);

        return this.userDao.create(user);
    }
}
