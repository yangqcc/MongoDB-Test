package com.yqc.getMongoDBConnection;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by Administrator on 2017/3/12.
 * <p>
 * The preferred way to reference the operations on MongoTemplate instance is via its
 * interface MongoOperations.
 */
@Configuration
public class MongoConfiguration {
    public
    @Bean
    MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "MY_DB");
    }

    public
    @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}
