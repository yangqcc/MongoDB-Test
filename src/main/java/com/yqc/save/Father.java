package com.yqc.save;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yangqc on 2017/4/1.
 */
@Document(collection = "father")
public class Father {

    private String id;
    private String name;
    private int age;

    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
