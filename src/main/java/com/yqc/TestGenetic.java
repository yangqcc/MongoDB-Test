package com.yqc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by yangqc on 2017/3/16.
 */
public class TestGenetic<T> {

    private Class getClazz() {
        ParameterizedType parameterizedType = (ParameterizedType) (this.getClass().getGenericSuperclass());
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
