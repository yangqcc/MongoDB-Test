package com.yqc.repository;

import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by yangqc on 2017/3/20.
 */
public class MyEntityRepositoryImpl implements MyEntityRepositoryCustom<Person> {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void saveTenTimes() {
        for (int i = 0; i < 10; i++) {
            mongoOperations.save(new MyEntity("dog" + i, i));
        }
    }
}
