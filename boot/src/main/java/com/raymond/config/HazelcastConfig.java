package com.raymond.config;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Raymond Kwong on 5/22/2016.
 */
@Configuration
public class HazelcastConfig extends com.hazelcast.config.Config {
    public HazelcastConfig() {
        super.setInstanceName("raymond");
        NetworkConfig networkConfg = new NetworkConfig();
        networkConfg.setPort( 5701 );
        networkConfg.setPortAutoIncrement( true );
        networkConfg.setPortCount( 100 );
        JoinConfig join = networkConfg.getJoin();
        join.getMulticastConfig().setEnabled( true );

        super.setNetworkConfig(networkConfg);

        ManagementCenterConfig managementCenterConfig = new ManagementCenterConfig();
        managementCenterConfig.setEnabled(true);
        managementCenterConfig.setUrl("http://localhost:8080/mancenter");
        super.setManagementCenterConfig(managementCenterConfig);

        MapConfig mapConfig = super.getMapConfig("test");
        NearCacheConfig nearCacheConfig = new NearCacheConfig();
        mapConfig.setNearCacheConfig(nearCacheConfig);
    }
}
