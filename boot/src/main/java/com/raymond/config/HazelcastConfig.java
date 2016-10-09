package com.raymond.config;

//import com.hazelcast.config.*;
//import com.hazelcast.core.Hazelcast;
//import com.hazelcast.core.HazelcastInstance;
//import com.hazelcast.web.SessionListener;
//import com.hazelcast.web.spring.SpringAwareWebFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpSessionListener;

//import static com.raymond.config.HazelcastConfig.SESSIONS_MAP_NAME;

/**
 * Created by Raymond Kwong on 5/22/2016.
 */
//Begin Hazelcast with Spring Session
//maxInactiveIntervalInSeconds here will override the Map's MaxIdleSeconds
//@EnableHazelcastHttpSession(sessionMapName = SESSIONS_MAP_NAME, maxInactiveIntervalInSeconds = 43200)
//End Hazelcast with Spring Session
@Configuration
public class HazelcastConfig {
    /*
    public static final String SESSIONS_MAP_NAME = "raymond-sessions";

    private static final String TEST_MAP = "test";

    private static MaxSizeConfig SMALL_USED_HEAP_SIZE_POLICY = new MaxSizeConfig(32, MaxSizeConfig.MaxSizePolicy.USED_HEAP_SIZE);//In megabytes, applies to Total Heap Cost, Owned + Backup

    //Begin Hazelcast with Spring Session
    @Bean
    public HazelcastInstance embeddedHazelcast() {
        Config hazelConfig = new Config();
        hazelConfig.setInstanceName("raymond");
        GroupConfig groupConfig = new GroupConfig();
        groupConfig.setName("raymond");
        groupConfig.setPassword("raymond123");
        hazelConfig.setGroupConfig(groupConfig);
        NetworkConfig networkConfg = new NetworkConfig();
        networkConfg.setPort( 5701 );
        networkConfg.setPortAutoIncrement( true );
        networkConfg.setPortCount( 100 );
        JoinConfig join = networkConfg.getJoin();
        join.getMulticastConfig().setEnabled( true );

        hazelConfig.setNetworkConfig(networkConfg);

        ManagementCenterConfig managementCenterConfig = new ManagementCenterConfig();
        managementCenterConfig.setEnabled(true);
        managementCenterConfig.setUrl("http://localhost:5080/mancenter");
        hazelConfig.setManagementCenterConfig(managementCenterConfig);

        initSessionMapConfig(hazelConfig);
        initMapConfigs(hazelConfig);
        return Hazelcast.newHazelcastInstance(hazelConfig);
    }*/
    //End Hazelcast with Spring Session

    //Start Regular Hazelcast without Spring Session
    /*@Bean
    public Config hazelConfig() {
        Config hazelConfig = new Config();
        hazelConfig.setInstanceName("raymond");
        GroupConfig groupConfig = new GroupConfig();
        groupConfig.setName("raymond");
        groupConfig.setPassword("raymond123");
        hazelConfig.setGroupConfig(groupConfig);
        NetworkConfig networkConfg = new NetworkConfig();
        networkConfg.setPort( 5701 );
        networkConfg.setPortAutoIncrement( true );
        networkConfg.setPortCount( 100 );
        JoinConfig join = networkConfg.getJoin();
        join.getMulticastConfig().setEnabled( true );

        hazelConfig.setNetworkConfig(networkConfg);

        ManagementCenterConfig managementCenterConfig = new ManagementCenterConfig();
        managementCenterConfig.setEnabled(true);
        managementCenterConfig.setUrl("http://localhost:6080/mancenter");
        hazelConfig.setManagementCenterConfig(managementCenterConfig);

        MapConfig mapConfig = hazelConfig.getMapConfig("my-sessions");

        return hazelConfig;
    }*/

    /*@Bean
    public FilterRegistrationBean hazelcastFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(someFilter());
        registration.setName("hazelcast-filter");
        registration.addUrlPatterns("/*");
        registration.setDispatcherTypes(DispatcherType.FORWARD);
        registration.setDispatcherTypes(DispatcherType.INCLUDE);
        registration.setDispatcherTypes(DispatcherType.REQUEST);

        registration.addInitParameter("instance-name", "raymond");
        registration.addInitParameter("map-name", "my-sessions");
        registration.addInitParameter("session-ttl-seconds", "1");
        registration.addInitParameter("cookie-name", "hazelcast.sessionId");
        return registration;
    }

    @Bean(name = "hazelcast-filter")
    public com.hazelcast.web.spring.SpringAwareWebFilter someFilter() {
        SpringAwareWebFilter springAwareWebFilter = new com.hazelcast.web.spring.SpringAwareWebFilter();
        return springAwareWebFilter;
    }

    @Bean
    public com.hazelcast.web.SessionListener sessionListener() {
        return new com.hazelcast.web.SessionListener();
    }*/
    //End Regular Hazelcast without Spring Session

    /*public static void initSessionMapConfig(Config config) {
        MapConfig mySession = config.getMapConfig(SESSIONS_MAP_NAME);
        mySession.setMaxSizeConfig(new MaxSizeConfig(256, MaxSizeConfig.MaxSizePolicy.USED_HEAP_SIZE));
        mySession.setEvictionPolicy(EvictionPolicy.LRU);
        //mySession.setMaxIdleSeconds(43200); //12 hrs because our normal session timeout is 12 hours
    }

    public static void initMapConfigs(Config config) {
        MapConfig mySession = config.getMapConfig(TEST_MAP);
        mySession.setMaxSizeConfig(SMALL_USED_HEAP_SIZE_POLICY);
        mySession.setEvictionPolicy(EvictionPolicy.LRU);
        mySession.setMaxIdleSeconds(45000);
    }*/
}
