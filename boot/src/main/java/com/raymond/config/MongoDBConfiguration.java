package com.raymond.config;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by Raymond Kwong on 6/27/2016.
 */
//mongo --host rs0/localhost:27017,localhost:27018,localhost:27019
//mongo --host rs0/localhost:27017,localhost:27018,localhost:27019 dist -u "admin" -p "password" --authenticationDatabase "admin"
@Configuration
public class MongoDBConfiguration {
    /*private MongoClientURI mongo() throws Exception {
        return new MongoClientURI("mongodb://dist:dist_app@localhost:27017,localhost:27018,localhost:27019/dist?replicaSet=rs0");
    }*/

    /*@Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongo());
    }*/

    /*@Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }*/
}
