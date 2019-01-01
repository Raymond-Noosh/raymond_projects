package com.raymond.resource.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Raymond Kwong on 12/31/2018.
 */
@RestController()
@RequestMapping("sample")
public class SampleResourceController {

    @GetMapping("/test")
    public ResponseEntity<String> testErrors() {
        ResponseEntity responseEntity = new ResponseEntity("test is ok", HttpStatus.OK);
        return responseEntity;
    }
}
