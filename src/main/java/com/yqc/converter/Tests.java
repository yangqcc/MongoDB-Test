package com.yqc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 测试类
 */
@Component
public class Tests {

    @Autowired
    MongoOperations mongoOperations;

    public void test() {
        List<MyPerson> list = mongoOperations.findAll(MyPerson.class, "person");
        for (MyPerson myPerson : list) {
            System.out.println(myPerson);
        }
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.converter");
        Tests tests = annotationContext.getBean("tests", Tests.class);
        tests.test();
    }
}
