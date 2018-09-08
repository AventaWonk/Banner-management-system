package com.splat.bms.service.impl;

import com.splat.bms.dao.BannerDao;
import com.splat.bms.model.Banner;
import com.splat.bms.service.AdminActionLoggingService;
import com.splat.bms.service.BannerService;
import com.splat.bms.validator.BannerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    private BannerDao bannerDao;
    private AdminActionLoggingService adminActionLoggingService;

    /**
     * Gets all existing banners
     *
     * @return List of banners
     */
    @Override
    public List<Banner> getAllBanners() {
        return this.bannerDao.findAll();
    }

    /**
     * Collects a new banner
     *
     * @param banner collecting banner
     * @return collected banner key
     */
    @Override
    public int addBanner(Banner banner) {
        int id = this.bannerDao.create(banner);
        this.adminActionLoggingService.log(0, id, "created");

        return id;
    }

    /**
     * Updates an existing banner
     *
     * @param banner  collecting banner
     */
    @Override
    public void updateBanner(Banner banner) {
        this.bannerDao.update(banner);
        this.adminActionLoggingService.log(0, banner.getId(), "updated");
    }

    /**
     * Removes an existing banner
     *
     * @param id of removing banner
     */
    @Override
    public void deleteBanner(int id) {
        this.bannerDao.remove(id);
        this.adminActionLoggingService.log(0, id, "removed");
    }

    @Autowired
    public void setBannerDao(BannerDao bannerDao) {
        this.bannerDao = bannerDao;
    }

    @Autowired
    public void setAdminActionLoggingService(AdminActionLoggingService adminActionLoggingService) {
        this.adminActionLoggingService = adminActionLoggingService;
    }
}
