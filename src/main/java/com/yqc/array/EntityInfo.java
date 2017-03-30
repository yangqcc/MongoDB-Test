package com.yqc.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangqc on 2017/3/30.
 */
public class EntityInfo {
    private String id;
    //记住名字一定要对应
    private List<Apple> apples;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Apple> getApples() {
        return apples;
    }

    public void setApples(List<Apple> apples) {
        this.apples = apples;
    }
}
