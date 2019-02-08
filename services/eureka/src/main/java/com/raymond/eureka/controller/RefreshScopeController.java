package com.raymond.eureka.controller;

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

    @GetMapping("/refreshtest")
    public String getServiceName() {
        return "refresh test value1: " + this.refreshtest;
    }
}
