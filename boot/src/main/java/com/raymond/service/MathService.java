package com.raymond.service;

/**
 * Created by Raymond Kwong on 5/17/2016.
 */
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class MathService {

    //@Cacheable//(cacheNames = "computePiDecimal", key = "pi")
    @Cacheable("books")
    public String computePiDecimal(String pi) {
        System.out.println("computePiDecimal");
        return "5555";
    }
}