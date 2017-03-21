package com.yqc.query;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.yqc.Person;
import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by yangqc on 2017/3/15.
 * 测试save和insert的区别，如果记录之前不存在，那么save和insert效果一样
 * 如果存在，save会更新记录，而insert会报错
 * <p>
 * {@link insert} inserts an object. If there is an existing document with the same id then an error is
 * generated.
 * {@link insertAll} takes a Collection of objects as the first parameter. This method inspects each object
 * and inserts it to the appropriate collection based on the rules specified above.
 * {@link save} saves the object overwriting any object that might exist with the same id.
 */
@Component
public class SaveAndInsert {

    @Autowired
    MongoOperations mongoOperations;

    public void saveAndInsert() {
        List<Fruit> fruitList = new ArrayList<Fruit>();
/*        for (int i = 0; i < 10; i++) {
            fruitList.add(new Fruit(new Integer(i).toString(), "orange" + i));
        }
        mongoOperations.insert(fruitList, Fruit.class);*/
        List multipleList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            multipleList.add(new Fruit("orange"));
        }
        for (int i = 0; i < 10; i++) {
            multipleList.add(new Person("person" + i, i));
        }
        /**
         * insertAll居然可以混合插入
         */
        mongoOperations.insertAll(multipleList);
        /*List<Fruit> fruitList1 = mongoOperations.findAll(Fruit.class);
        fruitList1.get(0).setName("Apple");
        mongoOperations.save(new Fruit("xxx"));
        mongoOperations.insert(new Fruit("2", "Orange"));*/
    }

    public void search() {
        BasicDBObject basicDBObject = new BasicDBObject();

        //mongoDB原生查询方法
       /* BasicDBObject basicDBObject = new BasicDBObject("sayHello", "yangqc1");
        basicDBObject.append("favorite", "favorite1");
        basicDBObject.append("age", 1);
        FindIterable<Document> personFindIterable = mongoOperations.getCollection("person").find(basicDBObject);
          for (Document document : personFindIterable) {
            System.out.println(document.toJson());
        }
        */

        /**
         * spring查询方法
         */

        Query query = Query.query(Criteria.where("sayHello").is("yangqc1").andOperator(Criteria.where("age").is(1).andOperator(Criteria.where("favorite").is("favorite1"))));
        List<Person> personList = mongoOperations.find(query, Person.class);
        for (Person person : personList) {
            System.out.println(person);
        }

        Bson bson = Filters.or(Filters.eq("favorite", "favorite1"), Filters.eq("sayHello", "yangqc1"), Filters.eq("age", 5));
        FindIterable<Document> documents = mongoOperations.getCollection("person").find(bson);
        for (Document document : documents) {
            System.out.println(document.toJson());
        }
    }

    public void increment() {
        Update update = new Update().inc("age", -1);
        mongoOperations.updateFirst(Query.query(Criteria.where("sayHello").is("yangqc1")), update, Person.class);
        System.out.println(mongoOperations.findOne(Query.query(Criteria.where("sayHello").is("yangqc1")), Person.class));
    }

    public void basicIncrement() {
        Bson filter = Filters.and(Filters.eq("sayHello", "yangqc1"), Filters.eq("favorite", "favorite1"));
        Bson update = new BasicDBObject("$inc", new BasicDBObject("age", 1));
        mongoOperations.getCollection("person").findOneAndUpdate(filter, update);
        System.out.println(mongoOperations.findOne(Query.query(Criteria.where("sayHello").is("yangqc1")), Person.class));
    }

    public void searchBasicObject() {
       /* Bson bson = new BasicDBObject("sayHello", "yangqc2").append("favorite", "favorite2").append("age", 2);
//        System.out.println(bson);
        FindIterable<Document> findIterable = mongoOperations.getCollection("person").find(bson);
        for (Document document : findIterable) {
            System.out.println(document.toJson());
        }*/

        Query query = Query.query(where("favorite").is("favorite2").and("sayHello").is("yangqc2"));
        Update update = new Update().inc("age", 1);
        mongoOperations.updateFirst(query, update, Person.class);
        System.out.println(mongoOperations.findOne(query, Person.class));
    }

    public void update() {
        Person person = mongoOperations.findOne(Query.query(where("sayHello").is("yangqc8")), Person.class);
        person.setName(null);
        person.setFavorite(null);
        mongoOperations.save(person);
        System.out.println(mongoOperations.findOne(Query.query(where("age").is(8)), Person.class));
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.query");
        // 创建bean的引用对象
        SaveAndInsert saveAndInsert = annotationContext.getBean("saveAndInsert", SaveAndInsert.class);
//        saveAndInsert.saveAndInsert();
//        saveAndInsert.search();
//        saveAndInsert.increment();
//        saveAndInsert.basicIncrement();
//        saveAndInsert.searchBasicObject();
        saveAndInsert.update();
    }
}
