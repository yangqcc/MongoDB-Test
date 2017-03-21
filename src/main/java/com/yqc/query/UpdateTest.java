package com.yqc.query;

import com.mongodb.client.result.UpdateResult;
import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import static org.springframework.data.mongodb.core.query.Criteria.*;

import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Update.update;

/**
 * Created by yangqc on 2017/3/15.
 */
@Component
public class UpdateTest {

    @Autowired
    MongoOperations mongoOperations;

    public void updateDocument() {
        UpdateResult updateResult = mongoOperations.updateMulti(new Query(where("sayHello").is("orange")), update("sayHello", "Not_Oragne"), Fruit.class);
    }

    public void testGroup() {
        GroupBy groupBy = GroupBy.key("sayHello");
        GroupByResults<Person> personGroupByResults = mongoOperations.group(Criteria.where("age").lte(10).gte(0), "person", groupBy, Person.class);
        /* System.out.println(personGroupByResults.getKeys());
        System.out.println(personGroupByResults.getCount());*/
    }

    public void testConverter() {
        List<LimitPerson> limitPersonList = mongoOperations.find(Query.query(where("sayHello").is("person2")), LimitPerson.class, "person");
//        System.out.println(limitPersonList.size());
        for (LimitPerson limitPerson : limitPersonList) {
            System.out.println(limitPerson);
        }
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.query");
        // 创建bean的引用对象
        UpdateTest updateTest = annotationContext.getBean("updateTest", UpdateTest.class);
//        updateTest.updateDocument();
//        updateTest.testConverter();
        updateTest.testGroup();
    }
}
