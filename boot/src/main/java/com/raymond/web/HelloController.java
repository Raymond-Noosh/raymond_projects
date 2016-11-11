package com.raymond.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Raymond Kwong on 3/27/2016.
 */
@RestController
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "{\"id\":1,\"content\":\"Hello, World!\"}";
    }
}
