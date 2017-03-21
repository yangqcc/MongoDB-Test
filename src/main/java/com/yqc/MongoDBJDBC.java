package com.yqc;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
public class MongoDBJDBC {
    public static void main(String args[]) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("MY_DB");
            System.out.println("Connect to database successfully");
            MongoCollection<Document> col = mongoDatabase.getCollection("TestMongoDB");
            Document document = new Document("sayHello", "MongoDB").append("type", "dataBase");
            col.insertOne(document);
            document = Document.parse("{'sayHello':'java'}");
            col.insertOne(document);
            List<Document> documents = new ArrayList<Document>();
            for (int i = 0; i < 10; i++) {
                documents.add(new Document("i", i));
            }
            col.insertMany(documents);

            /**
             * 文档查询
             */
            col.find();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
