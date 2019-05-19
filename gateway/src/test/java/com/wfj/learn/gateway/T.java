package com.wfj.learn.gateway;

import com.wfj.learn.gateway.utils.JwtUtils;

public class T {

    public static void main(String[] args) {
        JwtUtils jwtUtils = new JwtUtils();

        System.out.println(jwtUtils.generateToken("xx", 1));
        System.out.println("--------------------------------------------------------");
        System.out.println(jwtUtils.generateToken("1", 1));
        System.out.println("--------------------------------------------------------");
        System.out.println(jwtUtils.generateToken("18566217093", 1));
        System.out.println("--------------------------------------------------------");
        System.out.println(jwtUtils.generateToken("18566217093", 1));
        System.out.println("--------------------------------------------------------");
        System.out.println(jwtUtils.generateToken("18566217093", 1));
        System.out.println("--------------------------------------------------------");
        System.out.println(jwtUtils.generateToken("18566217093", 1));
        System.out.println("--------------------------------------------------------");
        System.out.println(jwtUtils.generateToken("18566217093", 1));
        System.out.println("--------------------------------------------------------");

    }
}
