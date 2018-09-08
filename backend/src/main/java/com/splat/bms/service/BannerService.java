package com.splat.bms.service;

import com.splat.bms.model.Banner;

import java.util.List;

public interface BannerService {

    /**
     * Gets all existing banners
     *
     * @return List of banners
     */
    List<Banner> getAllBanners();

    /**
     * Collects a new banner
     *
     * @param banner collecting banner
     * @return       created banner int id
     */
    int addBanner(Banner banner);

    /**
     * Updates an existing banner
     *
     * @param banner banner model with updated fields banner
     */
    void updateBanner(Banner banner);

    /**
     * Removes an existing banner
     *
     * @param id of removing banner
     */
    void deleteBanner(int id);

}
