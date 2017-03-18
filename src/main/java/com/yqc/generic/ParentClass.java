package com.yqc.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by yangqc on 2017/3/16.
 */
public class ParentClass<T, S> {

    public void getGenericType() {
        Type superClass = this.getClass().getGenericSuperclass();
        if (superClass instanceof Class) {
            throw new RuntimeException("Missing type parameter!");
        }
        ParameterizedType parameterizedType = (ParameterizedType) superClass;
        System.out.println(((Class<T>) parameterizedType.getActualTypeArguments()[0]).getName());
    }

    public static void testForIterator() {
        int n = 1;
        for (int i = 2; i < n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        testForIterator();
    }
}
