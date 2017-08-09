package com.yqc.connection;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

/**
 * Created by Administrator on 2017/3/12.
 */
@Configuration
public class AppConfig {

    @Bean
    public Mongo mongo() {
        return new MongoClient("localhost", 27017);
    }

    @Bean
    public MongoClientFactoryBean mongoClientFactoryBean() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("localhost");
        mongo.setPort(27017);
        return mongo;
    }
}
