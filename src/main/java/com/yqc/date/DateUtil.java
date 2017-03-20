package com.yqc.date;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Created by yangqc on 2017/3/20.
 */
public class DateUtil {

    public static LocalDate getCurrentDate() {
        LocalDate today = LocalDate.now();
        return today;
    }

    /**
     * 获取当月的第一天
     * @return
     */
    public static LocalDate getFirstDayOfMonth() {
        LocalDate firstDayOfThisMonth = getCurrentDate().with(TemporalAdjusters.firstDayOfMonth());
        return firstDayOfThisMonth;
    }

    /**
     * 获取当月的最后一天
     * @return
     */
    public static LocalDate getLastDayOfMonth() {
        LocalDate lastDayOfThisMonth = getCurrentDate().with(TemporalAdjusters.lastDayOfMonth());
        return lastDayOfThisMonth;
    }

    public static void main(String[] args) {
        System.out.println(getCurrentDate());
        System.out.println(getFirstDayOfMonth());
        System.out.println(getLastDayOfMonth());
    }
}
