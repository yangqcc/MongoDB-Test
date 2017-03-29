package com.yqc.lookup;

import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yangqc on 2017/3/15.
 */
@Component
public class LookUpTest {

    @Autowired
    MongoOperations mongoOperations;

    public void lookUpTest() {
        LookupOperation lookUp = Aggregation.lookup("orders", "sku", "item", "look");
        MatchOperation match = Aggregation.match(Criteria.where("look._id").exists(true));
        Aggregation aggregation = Aggregation.newAggregation(lookUp, match);
        AggregationResults<MyEntity> aggregationResults = mongoOperations.aggregate(aggregation, "lookupTest", MyEntity.class);
        for (MyEntity aggregationResult : aggregationResults) {
            System.out.println(aggregationResult);
        }
    }

    public void testDate() {
        Person person = new Person();
        person.setOperationTime(LocalDate.now());
        mongoOperations.save(person);
    }

    public void findEntity() {
        Person person = mongoOperations.findOne(Query.query(Criteria.where("id").is(1223)), Person.class);
        mongoOperations.updateFirst(Query.query(Criteria.where("id").is(1223)), Update.update("name", "yyyy"), Person.class);
        System.out.println(person);
    }

    /**
     * 批量提交
     */
    public void save() {
        Person[] persons;
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Person("我要啊！", 12, "香蕉"));
        }
        mongoOperations.insert(list, Person.class);
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.lookup");
        // 创建bean的引用对象
        LookUpTest lookUpTest = annotationContext.getBean("lookUpTest", LookUpTest.class);
//        lookUpTest.lookUpTest();
//        lookUpTest.findEntity();
        long t1 = new Date().getTime();
        lookUpTest.save();
        long t2 = new Date().getTime();
        System.out.println(t2 - t1);
    }
}
