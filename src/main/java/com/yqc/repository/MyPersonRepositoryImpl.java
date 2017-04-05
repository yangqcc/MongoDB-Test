package com.yqc.repository;

import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by yangqc on 2017/4/5.
 */
public class MyPersonRepositoryImpl implements MyEntityRepositoryCustom<Person> {

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public void saveTenTimes() {
        for (int i = 0; i < 10; i++) {
            mongoOperations.save(new Person());
        }
    }
}
