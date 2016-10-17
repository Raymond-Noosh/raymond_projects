package com.raymond.redis.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.raymond.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Raymond Kwong on 10/13/2016.
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void test(String key, String value) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put(key, value);
        saveString(key, objectNode.toString(), 30, TimeUnit.SECONDS);
        System.out.println(getString(key));
    }

    public void saveString(String key, String value, long timeout, TimeUnit timeUnit) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value, timeout, timeUnit);
    }

    public String getString(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String value = valueOperations.get(key);
        return value;
    }

    /**
     * Appear to can't set expiration
     * @param key
     * @param hashKey
     * @param value
     */
    public void saveHash(Object key, Object hashKey, Object value) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key, hashKey, value);
    }

    /**
     * Appear to can't set expiration
     * @param key
     * @param map
     */
    public void saveHashM(Object key, Map map) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key, map);
    }

    public Object getHash(Object key, Object hashKey) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        Object value = hashOperations.get(key, hashKey);
        return value;
    }
}
