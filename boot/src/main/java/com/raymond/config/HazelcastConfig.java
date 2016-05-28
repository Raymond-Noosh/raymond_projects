package com.raymond.config;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.web.SessionListener;
import com.hazelcast.web.spring.SpringAwareWebFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Raymond Kwong on 5/22/2016.
 */
//@EnableHazelcastHttpSession
@Configuration
public class HazelcastConfig {

    /*@Bean
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
        managementCenterConfig.setUrl("http://localhost:8080/mancenter");
        hazelConfig.setManagementCenterConfig(managementCenterConfig);
        return Hazelcast.newHazelcastInstance(hazelConfig);
    }*/

    @Bean
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
        managementCenterConfig.setUrl("http://localhost:8080/mancenter");
        hazelConfig.setManagementCenterConfig(managementCenterConfig);

        MapConfig mapConfig = hazelConfig.getMapConfig("my-sessions");

        return hazelConfig;
    }

    @Bean
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
    }
}
