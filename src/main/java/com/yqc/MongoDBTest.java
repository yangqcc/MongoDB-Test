package com.yqc;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
public class MongoDBTest {
    public static void main(String[] args) {
        try {
            ServerAddress serverAddress = new ServerAddress("localhost", 27017);
            List<ServerAddress> addresses = new ArrayList<ServerAddress>();
            addresses.add(serverAddress);
          /*  MongoCredential credential = MongoCredential.createCredential("admin", "MY_DB", new char[]{' '});
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);*/
            MongoClient mongoClient = new MongoClient(addresses);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("MY_DB");
            System.out.print("Connect to database successfully!");

            //创建集合
            //   mongoDatabase.createCollection("collectionName");
            System.out.print("Collection created successfully!");

            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("collectionName");
            Document document = new Document("title", "MongoDB").
                    append("description", "database").
                    append("likes", 100).append("by", "Fly");
            System.out.print(new Date());
            List<Document> documents = new ArrayList<Document>();
            for (int i = 0; i < 1000000; i++) {
                if (i == 6) {
                    break;
                }
                document = new Document("title", i);
               /* System.out.print(document.hashCode());*/
                documents.add(document);
            }
            mongoCollection.insertMany(documents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
