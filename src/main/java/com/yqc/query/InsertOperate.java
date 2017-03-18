package com.yqc.query;

import com.yqc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangqc on 2017/3/18.
 */
@Component
public class InsertOperate {

    @Autowired
    private MongoOperations mongoOperations;

    public void insert() {
        Person person;
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            person = new Person("yangqc" + i, i, "favorite" + i);
            personList.add(person);
        }
        mongoOperations.insert(personList, Person.class);
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.query");
        // 创建bean的引用对象
        InsertOperate insertOperate = annotationContext.getBean("insertOperate", InsertOperate.class);
        insertOperate.insert();
    }
}
