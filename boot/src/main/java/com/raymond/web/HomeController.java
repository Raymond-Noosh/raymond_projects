package com.raymond.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String root(Map<String, Object> model, HttpServletRequest request) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        LOG.info("root page");
        return "home";
    }

    @RequestMapping("/home")
    public String home(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        LOG.info("home page");
        return "home";
    }

    /*@RequestMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }*/

    @RequestMapping("/test")
    public String test(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        LOG.info("test page");
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
