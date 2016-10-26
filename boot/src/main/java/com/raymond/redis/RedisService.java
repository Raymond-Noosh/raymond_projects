package com.raymond.redis;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Raymond Kwong on 10/13/2016.
 */

public interface RedisService {
    public void saveString(String key, String value, long timeout, TimeUnit timeUnit);
    public String getString(String key);
    public void saveHash(Object key, Object hashKey, Object value);
    public void saveHashM(Object key, Map map);
    public Object getHash(Object key, Object hashKey);
    public void saveBoundHash(String hashKey, Object key, Object value, long timeout, TimeUnit timeUnit);
}
