package com.raymond.redis;

import org.springframework.stereotype.Service;

/**
 * Created by Raymond Kwong on 10/13/2016.
 */

public interface RedisService {
    public void save(String key, String value);
}
