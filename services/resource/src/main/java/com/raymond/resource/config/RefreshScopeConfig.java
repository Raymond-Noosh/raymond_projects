package com.raymond.resource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Raymond Kwong on 1/28/2019.
 */
@Component
@ConfigurationProperties(prefix="refresh", ignoreUnknownFields=false)
public class RefreshScopeConfig {

    @Value("${test2:defaultbetterchangeit}")
    private String test2;

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}
