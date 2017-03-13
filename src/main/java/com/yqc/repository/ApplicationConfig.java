package com.yqc.repository;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by Administrator on 2017/3/12.
 */
public class ApplicationConfig extends AbstractMongoConfiguration {
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return "MY_DB";
    }
}
