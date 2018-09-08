package com.splat.bms.dao.impl;

import com.splat.bms.dao.BannerDao;
import com.splat.bms.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class BannerDaoImpl implements BannerDao {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<Banner> bannerRowMapper;

    /**
     * Returns all banners contained in database
     *
     * @return list of all banners collected in database
     */
    @Override
    public List<Banner> findAll() {
        final String SELECT_SQL = "SELECT * FROM banner";

        return this.jdbcTemplate.query(SELECT_SQL, this.bannerRowMapper);
    }

    /**
     * Adds a new banner into database
     *
     * @param banner new banner record data
     * @return inserted banner record id
     */
    @Override
    public int create(Banner banner) {
        final String INSERT_SQL = "INSERT INTO banner (img_src, width, height, target_url, lang_id) " +
                "VALUES (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
            ps.setString(1, banner.getImgSrc());
            ps.setInt(2, banner.getWidth());
            ps.setInt(3, banner.getHeight());
            ps.setString(4, banner.getTargetUrl());
            ps.setInt(5, banner.getLangId());

            return ps;
        }, keyHolder);

        Number insertedId = keyHolder.getKey();
        if (insertedId == null) {
            return 0;
        }

        return insertedId.intValue();
    }

    /**
     * Updates existing banner record in database
     *
     * @param banner updated banner data
     */
    @Override
    public void update(Banner banner) {
        String sqlr = "UPDATE banners SET img_src = , width = , height = , target_url = , lang_id = WHERE";
    }

    /**
     * Removes existing banner record in database
     *
     * @param id of removing banner
     */
    @Override
    public void remove(int id) {
        final String DELETE_SQL = "DELETE FROM banner WHERE id = ?";

        this.jdbcTemplate.update(DELETE_SQL, id);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setBannerRowMapper(RowMapper<Banner> bannerRowMapper) {
        this.bannerRowMapper = bannerRowMapper;
    }
}
