package com.raymond.service;

/**
 * Created by Raymond Kwong on 5/17/2016.
 */
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class MathService {

    @Cacheable("books")
    public int computePiDecimal(int i) {
        System.out.println("Ttest");
        return 987654321;
    }



    

    

}