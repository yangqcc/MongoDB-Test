package com.yqc.query;

import java.util.Date;

/**
 * Created by yangqc on 2017/3/20.
 */
public class MyClass {

    private int count;
    private String year;
    private String month;
    private String dayOfMonth;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "count=" + count +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", dayOfMonth='" + dayOfMonth + '\'' +
                ", date=" + date +
                '}';
    }
}
