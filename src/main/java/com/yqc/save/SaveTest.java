package com.yqc.save;

import com.yqc.Person;
import com.yqc.lookup.MyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yangqc on 2017/3/15.
 */
@Component
public class SaveTest {

    @Autowired
    MongoOperations mongoOperations;

    public void saveEntity() {
        List<Child> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(new Child("father" + i, i, "child" + i));
        }
        mongoOperations.insert(list, Father.class);
    }

    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.save");
        SaveTest saveTest = annotationContext.getBean("saveTest", SaveTest.class);
        saveTest.saveEntity();
    }
}
