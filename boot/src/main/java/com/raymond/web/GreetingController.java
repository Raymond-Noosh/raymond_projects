package com.raymond.web;

import com.raymond.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheElement;
import org.springframework.data.redis.cache.RedisCacheKey;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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

    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private MathService mathService;

    @Autowired
    private CacheManager cacheManager;

    @Value("${name2}")
    private String name2;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Map<String, Object> model, HttpServletRequest request) {
        System.out.println("System out test");
        System.out.println("greeting got called");
        System.out.println(name2);

        String value = mathService.computePiDecimal("1");//no idea why this returns 1
        System.out.println(value);

        RedisCache cacheTest = (RedisCache) cacheManager.getCache("cacheTest");
        cacheTest.put("1", "ABC");
        Cache.ValueWrapper abc = cacheTest.get("1");
        String abcString = (String) abc.get();
        System.out.println(abcString);

        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("w", "t", "f");

        Cache test = cacheManager.getCache("test");
        test.put("1", "1");
        test.put("2", "2");
        test.put("3", "3");
        Cache.ValueWrapper one = test.get("1");
        System.out.println((String) one.get());

        Cache.ValueWrapper two = test.get("2");
        System.out.println((String) two.get());

        Cache.ValueWrapper three = test.get("3");
        System.out.println((String) three.get());

        model.put("name", name);

        ValueOperations<String, String> ops = this.template.opsForValue();
        String key = "spring.boot.redis.test";
        if (!this.template.hasKey(key)) {
            ops.set(key, "foo");
        }
        System.out.println("Found key " + key + ", value=" + ops.get(key));

        return "greeting";
    }

}
