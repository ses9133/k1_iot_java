package org.example.chapter15;

import java.util.ArrayList;
import java.util.List;


public class 연습용 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 4 ,2, 5, 1));
        List<Integer> sortedNum = list.stream()
                .sorted()
                .toList();
    }
}
