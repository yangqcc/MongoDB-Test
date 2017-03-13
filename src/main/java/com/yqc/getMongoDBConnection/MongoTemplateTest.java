package com.yqc.getMongoDBConnection;

import com.yqc.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;

/**
 * Created by Administrator on 2017/3/12.
 */
public class MongoTemplateTest {
    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc");
        MongoOperations mongoOperations = annotationContext.getBean("mongoTemplate", MongoTemplate.class);
        mongoOperations.insert(new Person("期成", 21));
        Person person = mongoOperations.findOne(query(where("name").is("期成")), Person.class);
        System.out.print(person);
    }
}
