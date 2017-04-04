package com.yqc.repository;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yangqc on 2017/4/4.
 */
@Document(collection = "My_Entity")
public class MyEntity {

    private String name;

    private int age;

    public MyEntity(String name, int age) {
        this.name = name;
        this.age = age;
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
