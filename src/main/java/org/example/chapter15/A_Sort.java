package org.example.chapter15;

import javax.swing.event.ListDataEvent;
import java.util.*;

/*
    === 스트림 API ===

    1. 스트림 생성: .stream()
    2. 중간 (가공) 절차
    3. 최종 절차

    === 자바의 정렬 ===
    1. 정렬
    : 데이터를 특정 기준에 따라 나열
    ex) 오름차순, 내림차순, 문자열 길이순정렬 (a, aa, aaa - 똑같은 문자일 경우 길이순으로 정렬됨)

    2. 배열(Arrays 클래스) 정렬
    : Arrays 클래스의 정적 메서드 (.sort()) 사용. Arrays.sort(참조변수) , Arrays.sort(참조변수, Collections.reverseOrder())
    >> 오름차순 정렬만 지원
        내림차순 정렬시 - Collections.reverseOrder() 정적 메서드 사용해야함

    3. 리스트(List 인터페이스) 정렬
    : Collections.sort() || List 인터페이스의 sort() 메서드를 사용 - Collections.sort(참조변수);
 */
public class A_Sort {
    public static void main(String[] args) {
        // [1] 배열 정렬
        // == 오름차순 ==
        int[] numbers = {5, 3, 2, 7, 1};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // == 내림차순 ===
        // : Collections 클래스의 reverseOrder() 사용
        // >> Comparator<T>를 반환하는 메서드 (객체 타입 간의 비교만 가능, 기본 데이터 타입은 비교 X)
        Integer[] nums = {5 ,3 ,2, 7, 1};
        Arrays.sort(nums, Collections.reverseOrder());
        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
        System.out.println(nums[3]);
        System.out.println(nums[4]);

        // [2] 리스트 정렬
        // == 오름차순 ==
        List<Integer> list = new ArrayList<Integer>(List.of(4, 2, 6 ,5));
       // Collections.sort(list);  -> Collections.sort()
        list.sort(null); // List 인터페이스의 sort() 메서드

        // cf) List.sort() 는 내부적으로 Comparator 을 전달받음
        //      >> 비교 기준을 정해주는 인터페이스
        // 1) null : 기본 정렬(오름차순) - String, Integer, Double 등의 단일 데이터가 Comparable 을 이미 구현
        // 2) Comparator : 지정한 Comparator 기준으로 정렬
        //      ex) 데이터의 변환( 문자열 -> 길이)
        //      ex) list.sort(Comparator.reverseOrder())
        List<String> listA = new ArrayList<>(List.of("aaa", "aaaaa", "aa", "a", "aaaaa"));
        listA.sort(Comparator.comparingInt(String::length));
        System.out.println(listA);
        System.out.println(list);

        // == 내림차순 ==
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // == Comparator 인터페이스 ==
        //: 사용자 정의 기준 정렬
        List<String> names = new ArrayList<>(List.of("Tom", "Jarry", "Pororo", "Loopy"));

        // 문자열 길이 기준 정렬
        // : 전체 순회해서 각 이름의 길이를 반환 > 오름차순 정렬
        names.sort(Comparator.comparingInt(String::length));
        System.out.println(names);

        // Comparator: 두개의 객체를 비교하는 로직을 담는 인터페이스
        //      >> 어떤 기준으로 정렬할지 개발자가 결정

        // [3] 스트림API 사용 정렬
        //: 정렬된 결과를 새로운 컬렉션으로 반환
        List<Integer> listNumber = new ArrayList<>(List.of(7, 2, 4, 5, 1));

        List<Integer> sortedNumber = listNumber.stream()
                .sorted()
                .toList();
        System.out.println(sortedNumber); // [1, 2, 4, 5, 7]
        System.out.println(listNumber); // [7, 2, 4, 5, 1] ** 원본 배열은 변하지 않음!!! streamAPI 의 불변성 특징

        // 내림차순
        List<Integer> sortedReverseNumber = listNumber.stream()
                .sorted((a, b) -> b - a)
                .toList();
        System.out.println(sortedReverseNumber); // [7, 5, 4, 2, 1]

        // cf) 정렬식(내림차순)
        // (a, b) -> b - a
        // : a 와 b는 리스트내의 두 요소임(순차적으로 담김)
        // - 두 요소를 비교한 결과를 반환
        //      1) 반환값이 양수: b 가 a보다 앞에 옴
        //      2) 반환 값이 0 : 순서 변경 X
        //      3) 반환 값이 음수: a 가 b보다 앞에 옴

        // +) 오름차순 (a, b) -> a - b 그대로

        List<String> charNames = new ArrayList<>(List.of("Tom", "Jarry", "Pororo", "Loopy"));
        List<String> sortedChar = charNames.stream()
                .sorted((n1, n2) -> n1.length() - n2.length())
                .toList();
        System.out.println(sortedChar); // [Tom, Jarry, Loopy, Pororo]

    }
}
