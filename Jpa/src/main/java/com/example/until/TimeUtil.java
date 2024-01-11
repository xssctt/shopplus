package com.example.until;

import com.example.entity.Member;

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
}
