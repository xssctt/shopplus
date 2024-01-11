package com.example.common;

import com.example.entity.Member;

public class ThreadContxt {
    private static final ThreadLocal<Member> cruuser=new ThreadLocal<>();

    public static Member getCruuser() {
        return cruuser.get();
    }

    public static void setCruuser(Member member) {
        cruuser.set(member);
    }
}
