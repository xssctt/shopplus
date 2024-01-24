package com.example.until;

import java.util.ArrayList;
import java.util.List;

public class StringCNumlist {
    public static List<Integer> StringToNumlist(String s){
        if(s.startsWith("[") && s.endsWith("}")){
            String d=s.substring(1,s.length()-1);

            String[] split = d.split(",");
            List<Integer> e=new ArrayList<>();

            for (String sb:split){
                e.add(Integer.valueOf(sb));
            }
            return e;
        }else {
            return null;
        }
    }
    public static String NumToString(List<Integer> s){
        return s.toString().substring(1,s.toString().length()-1);
    }

//    public static String StringToNum(List<Integer> s){
//        return s.toString().substring(1,s.toString().length()-1);
//    }

}
