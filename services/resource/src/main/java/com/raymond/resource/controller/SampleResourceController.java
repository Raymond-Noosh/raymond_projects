package com.raymond.resource.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raymond.resource.dto.UserCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Raymond Kwong on 12/31/2018.
 */
@RestController
@RequestMapping("sample")
public class SampleResourceController {

    private final static Logger logger = LoggerFactory.getLogger(SampleResourceController.class);

    @GetMapping("/test")
    public ResponseEntity<String> testErrors() {
        ResponseEntity responseEntity = new ResponseEntity("test is ok", HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<String> create(@RequestBody UserCredentials userCredentials) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            logger.info(mapper.writeValueAsString(userCredentials));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ResponseEntity responseEntity = new ResponseEntity("create is ok", HttpStatus.OK);
        return responseEntity;
    }
}
