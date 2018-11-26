package com.raymond.controller;

import com.raymond.config.JwtConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Raymond Kwong on 11/24/2018.
 */
@RestController
public class JwtController {
    private final static Logger logger = LoggerFactory.getLogger(JwtController.class);

    @Autowired
    private JwtConfig jwtConfig;

    @GetMapping("/jwt")
    public ResponseEntity<String> jwt() {
        logger.info(jwtConfig.getHeader());
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }
}
