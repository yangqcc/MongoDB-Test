package com.yqc.query;

/**
 * Created by yangqc on 2017/3/16.
 */
public class LimitPerson {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LimitPerson{" +
                "sayHello='" + name + '\'' +
                '}';
    }
}
