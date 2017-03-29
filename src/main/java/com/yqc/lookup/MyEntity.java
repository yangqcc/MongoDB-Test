package com.yqc.lookup;

import java.util.Arrays;

/**
 * Created by yangqc on 2017/3/23.
 */
public class MyEntity {
    private String id;
    private String item;
    private int instock;
    private Look[] look;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getInstock() {
        return instock;
    }

    public void setInstock(int instock) {
        this.instock = instock;
    }

    public Look[] getLook() {
        return look;
    }

    public void setLook(Look[] look) {
        this.look = look;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "id='" + id + '\'' +
                ", item='" + item + '\'' +
                ", instock=" + instock +
                ", look=" + Arrays.toString(look) +
                '}';
    }
}
