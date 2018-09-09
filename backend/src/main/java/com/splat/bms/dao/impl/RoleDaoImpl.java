package com.splat.bms.dao.impl;

import com.splat.bms.dao.RoleDao;
import com.splat.bms.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    /**
     * Gets user roles by user id
     *
     * @param id user id
     * @return List of user roles
     */
    @Override
    public List<Role> findByUserId(int id) {
        final String SELECT_SQL = "SELECT * FROM app_userrole INNER JOIN role on app_userrole.role_id = role.id " +
                "WHERE user_id = ?";

        return this.jdbcTemplate.query(SELECT_SQL, (resultSet, i) -> new Role(resultSet.getString("name")), id);
    }

    /**
     * @param userId
     * @param roleId
     */
    @Override
    public void addRoleToUser(int userId, int roleId) {
        final String INSERT_SQL = "";

//        this.jdbcTemplate.update()
    }


    /**
     * Creates new user role
     *
     * @param role new user role
     * @return inserted row id
     */
    @Override
    public int create(Role role) {
        return 0;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
