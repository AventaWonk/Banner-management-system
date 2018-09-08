package com.splat.bms.validator;

import com.splat.bms.model.Banner;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BannerValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Banner.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Banner banner = (Banner) o;
        if (!BannerValidator.isValidSource(banner.getImgSrc())) {
            errors.rejectValue("imgSrc", "incorrect image source");
        }

        if (!BannerValidator.isValidUrl(banner.getTargetUrl())) {
            errors.rejectValue("targetUrl", "incorrect target source");
        }

        if (!BannerValidator.isValidSize(banner.getWidth())) {
            errors.rejectValue("width", "incorrect width");
        }

        if (!BannerValidator.isValidSize(banner.getHeight())) {
            errors.rejectValue("height", "incorrect height");
        }
    };

    protected static boolean isValidSource(String string) {
        return string.matches("^[a-zA-Z0-9_\\-/:.\\ ]{0,255}$");
    }

    protected static boolean isValidUrl (String url) {
        return url.matches("^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?");
    }

    protected static boolean isValidSize (int size) {
        return (size > 0 && size < 10000);
    }

}
