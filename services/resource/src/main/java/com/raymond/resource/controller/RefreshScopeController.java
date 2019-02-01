package com.raymond.resource.controller;

import com.raymond.resource.config.RefreshScopeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger logger = LoggerFactory.getLogger(RefreshScopeController.class);

    @Value("${refresh.test:defaultbetterchangeit}")
    private String test;

    @Autowired
    private RefreshScopeConfig refreshScopeConfig;

    @GetMapping("/refreshtest")
    public String getServiceName() {
        logger.info("test: " + this.test+ ". test2: " + refreshScopeConfig.getTest2());
        return "1. RefreshScope-test: " + this.test
                + "\n2. ConfigurationProperties-test2: " + refreshScopeConfig.getTest2();
    }
}
