package com.raymond.resource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Raymond Kwong on 1/28/2019.
 */
@Component
@ConfigurationProperties(prefix="refresh")
public class RefreshScopeConfig {

    @Value("${test:defaultbetterchangeit}")
    private String test;

    public String getTest() {
        return test;
    }
}
