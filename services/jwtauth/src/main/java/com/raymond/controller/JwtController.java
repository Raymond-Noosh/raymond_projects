package com.raymond.controller;

import com.raymond.config.JwtConfig;
import com.raymond.entity.Student;
import com.raymond.service.StudentService;
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

    @Autowired
    private StudentService studentService;

    @GetMapping("/jwt")
    public ResponseEntity<String> jwt() {
        logger.info(jwtConfig.getHeader());
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/testErrors")
    public ResponseEntity<String> testErrors() {
        logger.info(jwtConfig.getHeader());

        if (1==1) {
            throw new NullPointerException();
            //throw new BadCredentialsException("test");
        }

        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/testResource")
    public ResponseEntity<String> testResource() {
        logger.info(jwtConfig.getHeader());

        Student student = studentService.findStudentById(10001L);
        logger.info(student.getName());

        Student student2 = studentService.findStudentByUsername("user2");
        logger.info(student2.getName());


        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }
}
