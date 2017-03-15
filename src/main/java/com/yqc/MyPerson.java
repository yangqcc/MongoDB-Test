package com.yqc;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yangqc on 2017/3/15.
 */
@Document(collection = "my_person")
public class MyPerson extends Person{

    public MyPerson() {
    }

    public MyPerson(String name, int age) {
        super(name, age);
    }

    public MyPerson(String name, int age, String favorite) {
        super(name, age, favorite);
    }
}
