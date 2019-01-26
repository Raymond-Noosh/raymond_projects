package com.raymond.resource.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raymond.resource.dto.UserCredentials;
import com.raymond.resource.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Raymond Kwong on 12/31/2018.
 */
@RefreshScope
@RestController
@RequestMapping("sample")
public class SampleResourceController {

    @Autowired
    private Environment environment;

    private final static Logger logger = LoggerFactory.getLogger(SampleResourceController.class);

    @GetMapping("/getLocalPort")
    public ResponseEntity<String> testErrors() {
        String[] activeProfiles = environment.getActiveProfiles();      // it will return String Array of all active profile.
        String port = environment.getProperty("local.server.port");
        StringBuffer buffer = new StringBuffer();
        for(String profile:activeProfiles) {
            buffer.append(profile);
        }
        ResponseEntity responseEntity = new ResponseEntity("v2: Using local port:"+port, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/getRandomUser")
    public ResponseEntity<UserDto> getRandomUser() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("John"+Math.random());
        userDto.setLastName("Doe"+Math.random());
        ResponseEntity responseEntity = new ResponseEntity(userDto, HttpStatus.OK);
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
