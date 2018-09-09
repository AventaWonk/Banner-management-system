package com.splat.bms.dao.impl;

import com.splat.bms.dao.UserDao;
import com.splat.bms.model.Role;
import com.splat.bms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> userRowMapper;

    /**
     * Returns existing user model by login an password
     *
     * @param login    unique string user login
     * @return user model if exists
     */
    @Override
    public User findByLogin(String login) {
        final String SELECT_SQL = "SELECT * FROM app_user WHERE login = ?";

        return  this.jdbcTemplate.queryForObject(SELECT_SQL, this.userRowMapper, login);
    }

    /**
     * Saves a new user into database and returns generated int id
     *

     * @return Created user id
     */
    @Override
    public int create(User user) {
        final String INSERT_SQL = "INSERT INTO app_user (login, password, date) values (?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setTimestamp(3, new Timestamp(user.getCreationDate().getTime()));

            return ps;
        }, keyHolder);

        Number insertedId = keyHolder.getKey();
        if (insertedId == null) {
            return 0;
        }

        return insertedId.intValue();
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setUserRowMapper(RowMapper<User> userRowMapper) {
        this.userRowMapper = userRowMapper;
    }
}
