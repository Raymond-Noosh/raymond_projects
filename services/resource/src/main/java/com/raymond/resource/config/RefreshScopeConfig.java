package com.raymond.resource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Raymond Kwong on 1/28/2019.
 */
@Component
@ConfigurationProperties
public class RefreshScopeConfig {

    @Value("${refresh.test:defaultbetterchangeit}")
    private String refreshtest;

    public String getRefreshtest() {
        return refreshtest;
    }
}
