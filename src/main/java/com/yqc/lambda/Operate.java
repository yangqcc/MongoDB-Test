package com.yqc.lambda;

import java.util.concurrent.Callable;

/**
 * Created by yangqc on 2017/4/3.
 */
public class Operate {

    public <T extends Dog> void add(T t) {
        System.out.println(t.getAge());
    }
}
