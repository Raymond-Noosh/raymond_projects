package com.raymond.web;

import com.raymond.redis.RedisService;
import com.raymond.redis.dto.SimpleBean;
import com.raymond.service.MathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    // inject the actual template
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MathService mathService;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private RedisService redisService;

    @Value("${name2}")
    private String name2;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Map<String, Object> model, HttpServletRequest request) {
        System.out.println("greeting got called");

        //Start Session Test
        String def = (String) request.getSession(false).getAttribute("def");
        System.out.println(def);
        request.getSession().setAttribute("def", "ghi");

        SimpleBean db = (SimpleBean) request.getSession().getAttribute("bean");
        System.out.println(db);
        if (db != null) {
            System.out.println(db.getNumber1() + " " + db.getNumber2() + " " + db.getNumber3());
        }

        SimpleBean bean = new SimpleBean();
        bean.setNumber1(1);
        bean.setNumber2(2);
        bean.setNumber3(3);
        request.getSession().setAttribute("bean", bean);
        //End Session Test

        String fff = redisService.getString("ab");
        System.out.println(fff);
        redisService.saveString("ab", "cd", 1, TimeUnit.MINUTES);

        redisService.saveString(""+System.nanoTime(), ""+System.nanoTime(), 1, TimeUnit.DAYS);

        String eee = (String) redisService.getHash("w", "a");
        System.out.println(eee);
        redisService.saveHash("w", "t", "f");
        redisService.saveHash("w", "t", "fhi");
        redisService.saveHash("w", "a", "b");
        redisTemplate.expire("w", 5, TimeUnit.MINUTES);

        String value = mathService.computePiDecimal("321");
        System.out.println(value);

        Cache cacheTest = cacheManager.getCache("cacheTest");
        Cache.ValueWrapper one = cacheTest.get("1");
        System.out.println((one == null) ? "null" : (String) one.get());
        Cache.ValueWrapper two = cacheTest.get("2");
        System.out.println((two == null) ? "null" : (String) two.get());
        cacheTest.put("1", "1");
        cacheTest.put("2", "2");

        model.put("name", name);
        return "greeting";
    }

}
