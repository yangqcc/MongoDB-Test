package com.yqc.generic;

/**
 * Created by yangqc on 2017/3/16.
 */
public class SubClassGeneric extends ParentClass<Integer, String> {

    public static void main(String[] args){
        new SubClassGeneric().getGenericType();
    }
}
