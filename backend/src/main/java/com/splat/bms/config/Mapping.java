package com.splat.bms.config;

import com.splat.bms.model.AdminAction;
import com.splat.bms.model.Banner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Mapping {

    @Bean
    RowMapper<AdminAction> getAdminActionRowMapper() {
        return (resultSet, i) -> {
            return new AdminAction()
                    .setId(resultSet.getInt("id"))
                    .setAdminId(resultSet.getInt("admin_id"))
                    .setBannerId(resultSet.getInt("banner_id"))
                    .setDescription(resultSet.getString("description"))
                    .setDate(new Date(resultSet.getTimestamp("date").getTime()));
        };
    }

    @Bean
    RowMapper<Banner> getBannerRowMapper() {
        return (resultSet, i) -> {
            return new Banner()
                    .setId(resultSet.getInt("id"))
                    .setImgSrc(resultSet.getString("img_src"))
                    .setWidth(resultSet.getInt("width"))
                    .setHeight(resultSet.getInt("height"))
                    .setTargetUrl(resultSet.getString("target_url"))
                    .setLangId(resultSet.getInt("lang_id"));
        };
    }

}
