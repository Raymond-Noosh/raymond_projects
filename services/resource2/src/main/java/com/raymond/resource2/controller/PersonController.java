package com.raymond.resource2.controller;

import com.netflix.discovery.converters.Auto;
import com.raymond.resource2.dto.UserDto;
import com.raymond.resource2.feign.ResourceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Raymond Kwong on 12/31/2018.
 */
@RestController
public class PersonController {

    @Autowired
    private ResourceClient resourceClient;

    @GetMapping("/test")
    public ResponseEntity<UserDto> testFeign() {
        UserDto userDto = resourceClient.getRandomUser();
        ResponseEntity responseEntity = new ResponseEntity(userDto, HttpStatus.OK);
        return responseEntity;
    }
}
