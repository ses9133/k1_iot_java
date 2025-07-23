package org.example.chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
    배열 vs 리스트
    +) 공통점: 순서 있음, 인덱스 번호로 접근 가능

    1. Array(배열)
        : 정적 자료 구조
        : 크기 고정: 생성시 지정한 크기에서 변경 불가능
        : 연속된 메모리 공간에 저장
        : 데이터가 동일한 타입이어야함 (명시적)
        +) 원소 추가, 삭제 불편함 - 직접 구현해야하기 때문

    2. List(리스트)
        : 동적 자료 구조
        : 크기 가변적
        : 메모리 공간이 불연속적
        : 다양한 구현체가 존재

    +) List<> 는 불변 리스트, 가변 리스트 모두 할당 가능

 */
public class D_Array_List {
    public static void main(String[] args) {
        // List 생성 방법
        // 1) new ArrayList<>();
        //      - 가변 가능 (길이 변경가능, 수정 가능)
        //      - 가장 일반적인 생성자 사용 리스트 생성 방식
        List<String> list = new ArrayList<>();

        // 2) Arrays.asList();
        //      - 가변 X (길이 고정, 수정은 가능)
        //      - 가짜 ArrayList: Arrays 클래스 내부에서 구현된 별개의 ArrayList (컬렉션프레임워크가 아님)
        //      - 배열을 리스트로 변환
        List<String> asListVar = Arrays.asList("a", "b", "c");

        // 3) List.of();
        //      - 불변 (길이 고정, 수정 불가)
        //      - 읽기 전용 리스트 생성
        //      - null 값을 포함할 수 없음
        List<String> listOfVar = List.of("a", "b");

        // 4) Stream.of().collect(Collectors.toList);
        //      - 가변 가능. (1번과 동일 형태)
        List<String> collectVar = Stream.of("a", "b", "c").toList();

        // 5) List.copyOf();
        //      - 불변 (길이 고정 ,수정 불가)
        //      - 기존 리스트의 불변 복사본 생성
        List<String> copyVar = List.copyOf(list);

    }
}
