package com.raymond.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by Raymond Kwong on 5/16/2016.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Map<String, Object> model, HttpServletRequest request) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        return "home";
    }

    @RequestMapping("/home")
    public String home2(Map<String, Object> model, HttpServletRequest request) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        return "home";
    }

    /*@RequestMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }*/
}
