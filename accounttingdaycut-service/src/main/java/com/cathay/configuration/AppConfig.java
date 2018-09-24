package com.cathay.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * AppConfig
 * <p>
 * Created by JamesTang on 16/12/15.
 */
@Component
public class AppConfig {

    @Autowired
    private Environment environment;

    // @Value("${app.mybatis.config.first}")
    private String appConfigFirst;

    public String getEnvFirstConfigValue() {
        return environment.getProperty("app.config.first");
    }

    public String getAnnotationAppConfigFirst() {
        return appConfigFirst;
    }
}
