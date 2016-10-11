package com.raymond.web;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String home2(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        return "home";
    }

    /*@RequestMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }*/

    @RequestMapping("/test")
    public String test(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        return "test";
    }

    @RequestMapping("/popup")
    public String popup(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        return "popup";
    }

    @RequestMapping("/store")
    public String store(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        return "store";
    }
}
