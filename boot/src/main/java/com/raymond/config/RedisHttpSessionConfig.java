package com.raymond.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Raymond Kwong on 10/8/2016.
 */
@EnableRedisHttpSession
public class RedisHttpSessionConfig {
    /**
     * configuration for sentinel
     */
    /*@Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
                .sentinel("192.168.1.24", 26379) .sentinel("192.168.1.25", 26379);
        return new JedisConnectionFactory(sentinelConfig);
    }*/


    /*@Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }*/



}
