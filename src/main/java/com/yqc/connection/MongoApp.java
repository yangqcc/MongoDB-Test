package com.yqc.connection;

import com.yqc.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Update.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 * using MongoTemplate to save,update or delete
 * it's very helpful
 * Static import of the 'Criteria.where' method will improve readability.
 * <p>
 * Which collection will my documents be saved into?
 * There are two ways to manage the collection name that is used for operating on the documents. The
 * default collection name that is used is the class name changed to start with a lower-case letter. So a
 * com.test.Person class would be stored in the "person" collection. You can customize this by
 * providing a different collection name using the @Document annotation. You can also override the
 * collection name by providing your own collection name as the last parameter for the selected
 * MongoTemplate method calls.
 * <p>
 * Inserting or saving individual objects
 * • {@link insert} inserts an object. If there is an existing document with the same id then an error is
 * generated.
 * • {@link insertAll } takes a Collection of objects as the first parameter. This method inspects each object
 * and inserts it to the appropriate collection based on the rules specified above.
 * • {@link save} saves the object overwriting any object that might exist with the same id.
 */
public class MongoApp {

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc");
        // 创建bean的引用对象
        MongoOperations mongoOperations = annotationContext.getBean("mongoTemplate", MongoTemplate.class);
        Person p = new Person("Joe", 34);
        mongoOperations.insert(p);

        p = mongoOperations.findById(p.getId(), Person.class);
        System.out.print(p);

        mongoOperations.updateFirst(query(where("name").is("Joe")), update("age", 35), Person.class);

//        p = mongoOperations.findOne(query(where("name").is("Joe")), Person.class);

        System.out.print(p);

//        mongoOperations.remove(p);

        List<Person> people = mongoOperations.findAll(Person.class);
        System.out.print(people.size());

//        mongoOperations.dropCollection(Person.class);
    }
}
