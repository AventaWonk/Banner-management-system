package com.splat.bms.controller;

import com.splat.bms.dto.ResponseDto;
import com.splat.bms.model.Banner;
import com.splat.bms.service.BannerService;
import com.splat.bms.validator.BannerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/banners")
public class BannerRestController {

    private BannerService bannerService;
    private BannerValidator bannerValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(this.bannerValidator);
    }

    @GetMapping("/get")
    public ResponseDto getAllBanners() {
        return ResponseDto.getSuccess(this.bannerService.getAllBanners());
    }

    @GetMapping("/create")
    public ResponseDto createBanner(@Valid Banner banner, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseDto.getError(bindingResult.getAllErrors());
        }

        int id = this.bannerService.addBanner(banner);
        return ResponseDto.getSuccess(id);
    }

    @PostMapping("/update")
    public ResponseDto updateBanner(@Valid Banner banner, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseDto.getError(bindingResult.getAllErrors());
        }

        this.bannerService.updateBanner(banner);
        return ResponseDto.getSuccess();
    }

    @GetMapping("/remove/{id}")
    public ResponseDto removeBanner(@PathVariable int id) {
        this.bannerService.deleteBanner(id);

        return ResponseDto.getSuccess();
    }

    @Autowired
    public void setBannerService(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @Autowired
    public void setBannerValidator(BannerValidator bannerValidator) {
        this.bannerValidator = bannerValidator;
    }

}
