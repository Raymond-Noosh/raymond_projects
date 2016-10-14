package com.raymond.redis.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.raymond.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by Raymond Kwong on 10/13/2016.
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void save(String key, String value) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put(key, value);

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        String jsonString = valueOperations.get("table1");
        System.out.println(jsonString);

        valueOperations.set("table1", objectNode.toString());

        System.out.println("Hi");
    }
}
