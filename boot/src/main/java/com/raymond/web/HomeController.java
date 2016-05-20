package com.raymond.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by Raymond Kwong on 5/16/2016.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        System.out.println("THE DEFAULT ONE");
        return "home";
    }

    @RequestMapping("/home")
    public String home2(Map<String, Object> model) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        System.out.println("THE DEFAULT TWO");
        return "home";
    }
}