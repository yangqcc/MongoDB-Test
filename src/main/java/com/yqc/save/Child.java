package com.yqc.save;

/**
 * Created by yangqc on 2017/4/1.
 */
public class Child extends Father {

    private String childName;

    public Child(String name, int age, String childName) {
        super(name, age);
        this.childName = childName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }
}
