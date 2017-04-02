package com.yqc.lambda;

/**
 * Created by yangqc on 2017/4/2.
 */
public class MyImplement {

    public void myExtend() {
        MyInterface myInterface = new MyInterface() {
            @Override
            public void sayName(String name) {

            }
        };

    }

    public static void main(String[] args) {
        MyInterface myInterface = (name) -> {
            System.out.println("this is sayName;");
            System.out.println(name);
        };

        myInterface.sayName("yangqc!");
    }
}
