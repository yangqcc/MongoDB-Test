package com.yqc.query;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqc on 2017/3/16.
 */
@Component
public class TimeUtil {

    @Autowired
    MongoOperations operations;

    @Autowired
    MongoTemplate mongoTemplate;

    public void testGroup() {
        GroupBy groupBy = GroupBy.key("sayHello");
     /*   List<Person> personList = operations.find(Query.query(Criteria.where("age").lte(10).gte(0)), Person.class);
        System.out.println(personList.size());*/
        GroupByResults<GroupFinalType> personGroupByResults = operations.group(Criteria.where("age").lte(10).gte(0), "person", new GroupBy("sayHello"), GroupFinalType.class);
        /* System.out.println(personGroupByResults.getKeys());
        System.out.println(personGroupByResults.getCount());*/
    }

/*    public void test2() {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase database = client.getDatabase("MY_DB");
        MongoCollection coll = database.getCollection("test");
        DBObject keys = new BasicDBObject("age", 1);
        DBObject condition = null;
        DBObject initial = new BasicDBObject("count", 0);
        String reduce = "function(doc,out){out.count++;}";
        String finalize = "function(out){return out;}";
        BasicDBList dbList = (BasicDBList) coll.group(keys, condition, initial, reduce, finalize);
        if (dbList != null) {
            for (int i = 0; i < dbList.size(); i++) {
                DBObject obj = (DBObject) dbList.get(i);
                Object age = obj.get("age");
                Object count = obj.get("count");
                System.out.println("age:" + age + ",count:" + count);
            }
        }
    }*/

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.query");
        // 创建bean的引用对象
        TimeUtil util = annotationContext.getBean("timeUtil", TimeUtil.class);
//        myPersonRepositoryTest.test();
        util.testGroup();
    }
}
