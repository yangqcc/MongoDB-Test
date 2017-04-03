package com.yqc.save;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Administrator on 2017/3/12.
 * 基本配置，配置数据源
 */
@Configuration
@EnableMongoRepositories
public class ApplicationConfig extends AbstractMongoConfiguration {

    public static final String collectionName = "t_db"; //MY_DB

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return collectionName;
    }
}
