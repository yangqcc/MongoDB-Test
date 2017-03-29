package com.yqc.query;

import com.mongodb.BasicDBObject;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

/**
 * Created by yangqc on 2017/3/19.
 * 测试aggregation聚合函数
 */
@Component
public class AggregationTest {

    @Autowired
    MongoOperations mongoOperations;

    public void matchName() throws ParseException {
        List<BasicDBObject> basicDBObjectList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date beginDate = sdf.parse("2013");
        Date endDate = sdf.parse("2015");
        BasicDBObject basicDBObject = new BasicDBObject("date", new BasicDBObject().append("$gt", beginDate).append("$lt", endDate));
        BasicDBObject match = new BasicDBObject("$match", basicDBObject);

        BasicDBObject basicDBObject1 = new BasicDBObject();
        basicDBObject1.append("month", new BasicDBObject("$month", "$date"));
//        basicDBObject1.append("day", new BasicDBObject("$dayOfMonth", "$date"));
        basicDBObject1.append("year", new BasicDBObject("$year", "$date"));
        BasicDBObject idBasic = new BasicDBObject("_id", basicDBObject1);
        idBasic.append("count", new BasicDBObject("$sum", 1));
        BasicDBObject group = new BasicDBObject("$group", idBasic);

        List<BasicDBObject> finalList = new ArrayList<>();
        System.out.println(match);
        finalList.add(match);
        finalList.add(group);
        AggregateIterable<Document> aggregateIterable = mongoOperations.getCollection("sales").aggregate(finalList);
        for (Document document : aggregateIterable) {
            System.out.println(document.toJson());
        }
    }

    /**
     * 测试聚合函数
     */
    public void searchAndGroupByDate() {
        AggregationOperation project = project().and("date").extractYear().as("year").and("date").extractMonth().as("month").and("date").extractDayOfMonth().as("dayOfMonth");
        AggregationOperation match = match(Criteria.where("year").is(2014));
        AggregationOperation group = group("year", "month", "dayOfMonth").count().as("count");
        AggregationOperation sort = sort(Sort.Direction.ASC, "year", "month", "dayOfMonth");
        Aggregation typedAggregation = newAggregation(project, match, group, sort);
        AggregationResults<MyClass> aggregationResults = mongoOperations.aggregate(typedAggregation, "sales", MyClass.class);
        for (MyClass myClass : aggregationResults) {
            System.out.println(myClass);
        }
    }

    public static void main(String[] args) throws ParseException {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.yqc.query");
        // 创建bean的引用对象
        AggregationTest aggregationTest = annotationContext.getBean("aggregationTest", AggregationTest.class);
//        aggregationTest.match();
        aggregationTest.searchAndGroupByDate();
    }

}
