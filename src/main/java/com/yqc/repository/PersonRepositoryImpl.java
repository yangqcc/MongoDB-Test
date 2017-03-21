package com.yqc.repository;

import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by yangqc on 2017/3/20.
 */
public class PersonRepositoryImpl implements PersonRepositoryCustom<Person> {

    @Autowired
    public MongoOperations mongoOperations;

    public PersonRepositoryImpl(MongoOperations operations) {
        this.mongoOperations = operations;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("sayHello");
    }
}
