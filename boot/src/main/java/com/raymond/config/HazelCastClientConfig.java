package com.raymond.config;

import com.hazelcast.config.NearCacheConfig;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by Raymond Kwong on 5/23/2016.
 */
//@Configuration
public class HazelcastClientConfig extends com.hazelcast.client.config.ClientConfig {
    public HazelcastClientConfig() {
        System.out.println("Client Config");
        /**
         * <near-cache name="default">
         <in-memory-format>BINARY</in-memory-format>
         <max-size>5000</max-size>
         <time-to-live-seconds>0</time-to-live-seconds>
         <max-idle-seconds>60</max-idle-seconds>
         <eviction-policy>LRU</eviction-policy>
         <invalidate-on-change>true</invalidate-on-change>
         <cache-local-entries>true</cache-local-entries>
         </near-cache>
         */


        NearCacheConfig cacheConfig = new NearCacheConfig("test");
        cacheConfig.setMaxSize(500);
        cacheConfig.setMaxIdleSeconds(60);
        cacheConfig.setEvictionPolicy("LRU");
        Map<String, NearCacheConfig> nearCacheConfigMap = super.getNearCacheConfigMap();
        nearCacheConfigMap.put("test", cacheConfig);
        super.setNearCacheConfigMap(nearCacheConfigMap);


    }
}
