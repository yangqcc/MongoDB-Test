package com.yqc.converter;

import org.springframework.stereotype.Component;
import sun.misc.Contended;

/**
 * Created by yangqc on 2017/3/21.
 */
public class MyPerson {

    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
