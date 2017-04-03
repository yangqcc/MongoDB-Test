package com.yqc;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;

/**
 * Created by Administrator on 2017/3/12.
 */
public class MongoApp {
 /*   private static final Log log = LoggerFactory.getLog(MongoApp.class);*/

    public static void main(String[] args) throws Exception {
        MongoOperations mongoOps = new MongoTemplate(new MongoClient(), "MY_DB");
        mongoOps.insert(new Person("Joe", 34, "orange"));
        Person person = mongoOps.findOne(query(where("sayHello").is("Joe")), Person.class);
        System.out.print(person);
//        log.info(mongoOps.findOne(new Query(where("sayHello").is("Joe")), Cat.class));
//        mongoOps.dropCollection("person");
    }
}

