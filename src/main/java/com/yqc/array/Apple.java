package com.yqc.array;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yangqc on 2017/3/30.
 */
@Document(collection = "apple")
public class Apple {

    private String appleName;
    private int appleCount;
    private String _class;

    public Apple() {
    }

    public Apple(String appleName, int appleCount, String _class) {
        this.appleCount = appleCount;
        this.appleName = appleName;
        this._class = _class;
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
        return "Apple{" +
                "appleName='" + appleName + '\'' +
                ", appleCount=" + appleCount +
                '}';
    }
}
