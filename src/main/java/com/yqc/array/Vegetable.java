package com.yqc.array;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by yangqc on 2017/3/30.
 */
@Document(collection = "vegetable")
public class Vegetable {
    private List<Apple> appleList;

    public List<Apple> getAppleList() {
        return appleList;
    }

    public void setAppleList(List<Apple> appleList) {
        this.appleList = appleList;
    }
}
