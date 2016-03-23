package com.raymond.config;

import com.raymond.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Raymond Kwong on 3/23/2016.
 */
@Configuration
public class AppConfig {

    @Bean
    public Person getPersonBean(){
        return new Person();
    }
}
