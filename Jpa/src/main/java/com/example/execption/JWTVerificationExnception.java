package com.example.execption;

public class JWTVerificationExnception extends RuntimeException{
    public JWTVerificationExnception(String message) {
        super(message);
    }
    public JWTVerificationExnception() { }

    /**
     * 丢出一个异常
     *
     * @param message
     */
    public static void fail(String message) {
        throw new JWTVerificationExnception(message);
    }
}