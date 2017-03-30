package com.yqc.array;

import com.yqc.Person;
import com.yqc.lookup.MyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by yangqc on 2017/3/15.
 */
@Component
public class ArrayTest {

    @Autowired
    MongoOperations mongoOperations;

    public void saveFruit() {
        Fruit fruit = new Fruit();
        fruit.setAppleList(new ArrayList<>());
        Apple apple;
        for (int i = 0; i < 10; i++) {
            apple = new Apple("apple" + i, i, Apple.class.getName());
            fruit.getAppleList().add(apple);
        }
        mongoOperations.save(fruit);
    }

    public void getFruit() {
        List<Fruit> fruits = mongoOperations.findAll(Fruit.class);
        for (Fruit fruit : fruits) {
            for (Apple apple : fruit.getAppleList()) {
                System.out.println(apple);
            }
        }
    }

    public void saveVegetable() {
        Vegetable vegetable = new Vegetable();
        vegetable.setAppleList(new ArrayList<>());
        Apple apple = null;
        for (int i = 0; i < 10; i++) {
            apple = new Apple("apple" + i, i, Apple.class.getName());
            vegetable.getAppleList().add(apple);
        }
        mongoOperations.save(vegetable);
    }

    public void lookUpOperate() {
      /*  LookupOperation lookUp = Aggregation.lookup("vegetable", "appleList.appleName", "appleList.appleName", "list");
        Aggregation aggregation = Aggregation.newAggregation(lookUp);
        AggregationResults<EntityInfo> entityInfos = mongoOperations.aggregate(aggregation, Fruit.class, EntityInfo.class);
        for (EntityInfo entityInfo : entityInfos) {
            System.out.println(entityInfo);
            for (Apple apple : entityInfo.getList()) {
                System.out.println(apple);
            }
        }*/
    }

    public void saveAppleAnOrange() {
        List<Apple> apples = new ArrayList<>();
        List<Orange> oranges = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            apples.add(new Apple("apple" + i, i, Apple.class.getName()));
            oranges.add(new Orange("apple" + i, i));
        }
        mongoOperations.insert(apples, Apple.class);
        mongoOperations.insert(oranges, Orange.class);
    }

    public void appleLookUpOrange() {
        LookupOperation lookUp = Aggregation.lookup("orange", "appleCount", "appleCount", "apples");
        ProjectionOperation project = Aggregation.project("apples");
        MatchOperation match = Aggregation.match(where("apples"));
        Aggregation aggregation = Aggregation.newAggregation(lookUp, project);
        System.out.println(aggregation);

        AggregationResults<EntityInfo> arrayLists = mongoOperations.aggregate(aggregation, Apple.class, EntityInfo.class);
        for (EntityInfo entityInfo : arrayLists) {
            System.out.println(Arrays.toString(entityInfo.getApples().toArray()));
        }

    }

    public void arraySearch() {
        UnwindOperation unwind = Aggregation.unwind("appleList");
        MatchOperation match = Aggregation.match(where("appleList.appleName").is("apple1"));
//        ProjectionOperation project = Aggregation.project("appleList");
        Aggregation aggregation = Aggregation.newAggregation(unwind, match);
        AggregationResults<com.yqc.array.MyEntity> aggregationResults = mongoOperations.aggregate(aggregation, Fruit.class, com.yqc.array.MyEntity.class);
        for (com.yqc.array.MyEntity myEntity : aggregationResults) {
            System.out.println(myEntity.getAppleList());
        }
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.array");
        // 创建bean的引用对象
        ArrayTest arrayTest = annotationContext.getBean("arrayTest", ArrayTest.class);
//        arrayTest.saveAppleAnOrange();
//        arrayTest.appleLookUpOrange();
        arrayTest.arraySearch();
    }
}
