package com.yqc;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.sun.org.apache.xalan.internal.xsltc.dom.FilterIterator;
import org.bson.Document;

/**
 * MongoDB基础查询
 * Created by Administrator on 2017/3/11.
 */
public class MongoDBSearch {
    public static void main(String[] args) {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = client.getDatabase("MY_DB");
        MongoCollection collection = mongoDatabase.getCollection("collectionName");
       /* FindIterable<Document> db = collection.find();*/

        /*FindIterable<Document> db = collection.find(new Document("title", new Document("$eq", 0)));*/

        /*FindIterable<Document> db = collection.find(new Document("title", new Document("$ne", 0)));*/

        /**
         * 通过Filter查询
         */
       /* FindIterable<Document> db = collection.find(Filters.eq("title", 0));*/

        /**
         * Filter查询，不等于
         */
        /*FindIterable<Document> db = collection.find(Filters.ne("title", 0));*/

        FindIterable<Document> db = collection.find(Filters.or(Filters.eq("title", 0), Filters.gt("title", 4)));

        for (Document document : db) {
            System.out.println(document.toJson());
        }
    }
}
