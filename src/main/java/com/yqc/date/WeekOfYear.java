package com.yqc.date;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yangqc on 2017/3/21.
 */
public class WeekOfYear {

    public static void weekOfYear() {
        LocalDate localDate = LocalDate.now();
        Calendar calendar = Calendar.getInstance();
        calendar.set(localDate.getYear(), localDate.getMonthValue()-1, localDate.getDayOfMonth());
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
    }

    public static void weekOfYearByDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
    }

    public static void main(String[] args) {
        weekOfYear();
        weekOfYearByDate();
    }
}
