package org.example.chapter15;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    === 스트림 API 의 최종 연산 ===
    1. collect 메서드
    : 스트림의 요소를 변화, 집계하여 최종 결과를 생성하는데 사용
    - 스트림 종결 작업 중 하나
    - 특정 컨테이너(List,Set, Map) 으로 변환하거나 값을 합산, 집계 하는데에 사용

    2. Collectors 클래스
    : 다양한 Collectors 를 제공하여 collect() 메서드와 결합해 하나의 결과를 반환
    - 다양한 정적 메서드를 제공
    1) toList, toSet, toMap : 해당 컬렉션으로 값 반환
    2) joining() : 문자열 요소 연결
    3) counting() : 스트림의 요소 개수 계산
    4) grouping() : 요소를 그룹화
    5) partitioningBy() : 스트림 요소를 조건에 따라 두 그룹으로 나눔

 */

public class C_Collect {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("java", "python", "javascript");

        // Collectors.toList()
        List<String> upperLanguages = languages.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperLanguages); // 순서 O

        // Collectors.toSet()
        Set<String> upperLanguagesToSet = languages.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println(upperLanguagesToSet); // 순서 X

        // Collectors.joining(delimiter, prefix(접두사), suffix(접미사))
        String result = upperLanguages.stream()
                .collect(Collectors.joining(", ", "[ ", " ]"));
        System.out.println(result);

        // Collectors.groupingBy()
        // : 요소를 특정 기준에 따라 그룹화
        Map<Character, List<String>> groupedByFirstChar = upperLanguages.stream()
                .collect(Collectors.groupingBy(language -> language.charAt(0)));
        //.collect(Collectors.groupingBy(String::charAt(0))); -> 인자를 받기 때문에 메서드 참조 안됨
        System.out.println(groupedByFirstChar);

        // Collectors.partitioningBy()
        Map<Boolean, List<Integer>> partitioned = Stream.of(1, 2, 3, 4, 5)  // Stream.of() : 참조변수를 통해 stream 을 만드는 것이 아니라 바로 stream 생성할 때 사용하는 문법
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(partitioned);
    }
}
