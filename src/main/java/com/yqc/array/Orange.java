package com.yqc.array;

/**
 * Created by yangqc on 2017/3/30.
 */
public class Orange {

    private String appleName;
    private int appleCount;

    public Orange(String appleName, int appleCount) {
        this.appleCount = appleCount;
        this.appleName = appleName;
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public int getAppleCount() {
        return appleCount;
    }

    public void setAppleCount(int appleCount) {
        this.appleCount = appleCount;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "orangeName='" + appleName + '\'' +
                ", appleCount=" + appleCount +
                '}';
    }
}
