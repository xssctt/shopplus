package com.example.until;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static String NowTimeToString(){
        LocalDateTime currentTime = LocalDateTime.now();
        // 格式化时间，可选
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String formattedTime = currentTime.format(formatter);

        return currentTime.format(formatter);
    }

    public static String NextTimeToString(Integer m){
        LocalDateTime currentTime = LocalDateTime.now();

        // 计算下一个月的年份和月份
        int nextYear = currentTime.getYear() + (currentTime.getMonthValue() + m - 1) / 12;
        int nextMonth = (currentTime.getMonthValue() + m - 1) % 12 + 1;

        LocalDateTime nextTime=LocalDateTime.of(nextYear,nextMonth,currentTime.getDayOfMonth(), currentTime.getHour(),currentTime.getMinute());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return nextTime.format(formatter);
    }

    public static LocalDateTime NowTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime;
    }

    public static LocalDateTime NextTime(Integer m){
        LocalDateTime currentTime = LocalDateTime.now();

        // 计算下一个月的年份和月份
        int nextYear = currentTime.getYear() + (currentTime.getMonthValue() + m - 1) / 12;
        int nextMonth = (currentTime.getMonthValue() + m - 1) % 12 + 1;

        LocalDateTime nextTime=LocalDateTime.of(nextYear,nextMonth,currentTime.getDayOfMonth(), currentTime.getHour(),currentTime.getMinute());

        return nextTime;
    }
}
