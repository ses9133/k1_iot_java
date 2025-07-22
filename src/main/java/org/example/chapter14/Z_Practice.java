package org.example.chapter14;

import java.util.function.Function;

public class Z_Practice {
    public static void main(String[] args) {

//        Function<String, Integer> func = s -> {
//            return s.length();
//        };
        Function<String, Integer> func = String::length; // String 의 인스턴스메서드(length)참조
        System.out.println(func.apply("abc")); // 3
    }
}




