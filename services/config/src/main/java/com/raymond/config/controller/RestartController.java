package com.raymond.config.controller;

import com.raymond.config.service.RestartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Raymond Kwong on 1/21/2019.
 */
@RestController
public class RestartController {

    @Autowired
    RestartService restartService;

    @PostMapping("/restart")
    public void restart() {
        System.out.println("restart");
        restartService.restartApp();
    }
}