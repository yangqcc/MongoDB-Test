package com.yqc.array;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by yangqc on 2017/3/30.
 */
@Document(collection = "fruit")
public class Fruit {

    private String name;
    private int count;
    private List<Apple> appleList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Apple> getAppleList() {
        return appleList;
    }

    public void setAppleList(List<Apple> appleList) {
        this.appleList = appleList;
    }
}
