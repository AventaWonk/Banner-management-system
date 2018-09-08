package com.splat.bms.dao.impl;

import com.splat.bms.dao.AdminActionDao;
import com.splat.bms.model.AdminAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class AdminActionDaoImpl implements AdminActionDao {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<AdminAction> adminActionRowMapper;

    /**
     * Returns all adminActions in db with specified banner id
     *
     * @param id of target banner
     * @return list of adminActions
     */
    @Override
    public List<AdminAction> findByBannerId(int id) {
        final String SELECT_WHERE_SQL = "SELECT * FROM admin_action WHERE banner_id = ?";

        return this.jdbcTemplate.query(SELECT_WHERE_SQL, this.adminActionRowMapper, id);
    }

    /**
     * Returns all adminActions in db with specified admin id
     *
     * @param id of admin
     * @return list of adminActions
     */
    @Override
    public List<AdminAction> findByAdminId(int id) {
        final String SELECT_WHERE_SQL = "SELECT * FROM admin_action WHERE admin_id = ?";

        return this.jdbcTemplate.query(SELECT_WHERE_SQL, this.adminActionRowMapper, id);
    }

    /**
     * Returns all adminActions contained in database
     *
     * @return list of all adminAction
     */
    @Override
    public List<AdminAction> findAll() {
        final String SELECT_SQL = "SELECT * FROM admin_action";

        return this.jdbcTemplate.query(SELECT_SQL, this.adminActionRowMapper);
    }

    /**
     * Adds a new adminAction into database
     *
     * @param adminAction new adminAction record data
     * @return inserted adminAction record id
     */
    @Override
    public int create(AdminAction adminAction) {
        final String INSERT_SQL = "INSERT INTO admin_action (admin_id, banner_id, description, date) " +
                "VALUES (?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
            ps.setInt(1, adminAction.getAdminId());
            ps.setInt(2, adminAction.getBannerId());
            ps.setString(3, adminAction.getDescription());
            ps.setTimestamp(4, new Timestamp(adminAction.getDate().getTime()));

            return ps;
        }, keyHolder);

        Number insertedId = keyHolder.getKey();
        if (insertedId == null) {
            return 0;
        }

        return insertedId.intValue();
    }

    /**
     * Updates existing adminAction record in database
     *
     * @param adminAction updated adminAction data
     */
    @Override
    public void update(AdminAction adminAction) {
        this.jdbcTemplate.update("");
    }

    /**
     * Removes existing adminAction record in database
     *
     * @param id of removing adminAction
     */
    @Override
    public void remove(int id) {
        final String DELETE_SQL = "DELETE FROM admin_action WHERE id = ?";

        this.jdbcTemplate.update(DELETE_SQL, id);

    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setAdminActionRowMapper(RowMapper<AdminAction> adminActionRowMapper) {
        this.adminActionRowMapper = adminActionRowMapper;
    }
}
