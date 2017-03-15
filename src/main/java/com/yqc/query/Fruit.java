package com.yqc.query;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yangqc on 2017/3/15.
 */
@Document(collection = "fruit")
public class Fruit {

    @Id
    private String id;

    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    @PersistenceConstructor
    public Fruit(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
