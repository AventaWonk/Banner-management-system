package com.splat.bms.dao;

import com.splat.bms.model.Banner;

import java.util.List;

public interface BannerDao {

    /**
     * Returns all banners contained in database
     *
     * @return list of all banners collected in database
     */
    List<Banner> findAll();

    /**
     * Adds a new banner into database
     *
     * @param banner new banner record data
     * @return       inserted banner record id
     */
    int create(Banner banner);

    /**
     * Updates existing banner record in database
     *
     * @param banner updated banner data
     */
    void update(Banner banner);

    /**
     * Removes existing banner record in database
     *
     * @param id of removing banner
     */
    void remove(int id);

}
