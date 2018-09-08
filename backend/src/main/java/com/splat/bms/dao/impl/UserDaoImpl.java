package com.splat.bms.dao.impl;

import com.splat.bms.dao.UserDao;
import com.splat.bms.model.Role;
import com.splat.bms.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    /**
     * Returns existing user model by login an password
     *
     * @param login    unique string user login
     * @param password string user password
     * @return user model if exists
     */
    @Override
    public User findByLoginAndPassword(String login, String password) {
        final String SELECT_SQL = "SELECT * FORM users WHERE login = ? AND password = ?";

        return null;
    }

    /**
     * Saves a new user into database and returns generated int id
     *
     * @param login    unique string user login
     * @param password string user password
     * @param roles    List of user roles
     * @param date     Date of creation
     * @return Created user id
     */
    @Override
    public int create(String login, String password, List<Role> roles, Date date) {
        final String INSERT_SQL = "INSERT INTO users () values (?, ?, ?)";

        return 0;
    }

}
