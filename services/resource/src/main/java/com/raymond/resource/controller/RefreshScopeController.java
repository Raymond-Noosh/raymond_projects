package com.raymond.resource.controller;

import com.raymond.resource.config.RefreshScopeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Raymond Kwong on 1/22/2019.
 */
@RefreshScope
@RestController
public class RefreshScopeController {
    @Value("${refresh.test:defaultbetterchangeit}")
    private String refreshtest;

    @Autowired
    RefreshScopeConfig refreshScopeConfig;


    @GetMapping("/refreshtest")
    public String getServiceName() {
        return "1. configuration test: " + refreshScopeConfig.getRefreshtest()
                + "\n2. refresh test value: " + this.refreshtest;
    }
}
