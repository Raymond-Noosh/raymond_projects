package com.raymond.service;

/**
 * Created by Raymond Kwong on 5/17/2016.
 */
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Component;

@Component
public class MathService {

    //No expiration
    @Cacheable(value = "piAnnotation")
    public String computePiDecimal(String pi) {
        String value = "piAnnotation"+System.nanoTime();
        return value;
    }
}