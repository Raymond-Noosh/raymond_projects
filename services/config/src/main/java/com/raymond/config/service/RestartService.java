package com.raymond.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.stereotype.Service;

/**
 * Created by Raymond Kwong on 1/21/2019.
 */
@Service
public class RestartService {

    @Autowired
    private RestartEndpoint restartEndpoint;

    public void restartApp() {
        restartEndpoint.restart();
    }
}