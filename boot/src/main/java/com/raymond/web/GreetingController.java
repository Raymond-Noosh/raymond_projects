package com.raymond.web;

import com.raymond.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private MathService mathService;

    @Autowired
    private CacheManager cacheManager;

    @Value("${name2}")
    private String name2;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Map<String, Object> model, HttpServletRequest request) {
        System.out.println("System out test");
        logger.info("greeting got called");
        logger.info(name2);

        mathService.computePiDecimal(1);

        Cache test = cacheManager.getCache("test");
        test.put("1", "1");
        test.put("2", "2");
        test.put("3", "3");

        Cache cacheTest = cacheManager.getCache("cacheTest");
        cacheTest.put("1", "ABC");
        Cache.ValueWrapper abc = cacheTest.get("1");
        String abcString = (String) abc.get();
        logger.info(abcString);

        Cache.ValueWrapper one = test.get("1");
        logger.info((String) one.get());

        Cache.ValueWrapper two = test.get("2");
        logger.info((String) two.get());

        model.put("name", name);
        return "greeting";
    }

}
