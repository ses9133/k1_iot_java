package org.example.chapter15;

/*
    === Optional 클래스 ===
    : 값이 존재할 수 도 있고, 없을 수도 있는 객체를 감싸는 컨테이너 (자바8 이후)
    - null 값을 다룰 때 발생하는 NullPointerException(NPE) 방지
    - null 체크를 명시적으로 안전하게 처리
    +) 함수형 프로그래밍 스타일 지원

 */

import java.util.Optional;

class Person {
    String name;
}

public class E_Optional {

    static String findNameById(int id) {
        return null;    // 실제 DB나 Map 에서 검색한다고 가정 >> 못찾으면 null 반환
    }

    public static void main(String[] args) {
        // cf) NPE: null 참조된 객체에 접근할 때 발생하는 예외
//        String name = null;
//        System.out.println(name.length()); // NullPointerException
//
//        Person p = null;
//        System.out.println(p.name); // NullPointerException
//
//        String[] arr = new String[3];
//        arr[0] = "abc";
//        System.out.println(arr[1].toUpperCase()); // NullPointerException
//
//        String result = findNameById(123);
//        System.out.println(result); // NullPointerException
//        System.out.println(result.toLowerCase()); // NullPointerException


        // 1. Optional 클래스
        // : null 이 아닌 값을 포함하거나, 값이 없는 상태를 나타낼 수 있음
        // - 값을 명시적으로 검사하고 처리하는 방식

        // 2. Optional<T> 생성 방법

        // 1) Optional.of(T value): null 이 아닌 값을 감쌈 (null 전달시 NPE 발생함)
        // Optional<String> optional0 = Optional.of(null); // NullPointerException
        Optional<String> optional1 = Optional.of("Hello Optional!");

        // 2) Optional.ofNullable(T value): null 여부 상관없이 Optional 생성 (null 일 경우 빈 Optional)
        Optional<String> optional2 = Optional.ofNullable(null);

        // 3) Optional.empty() : 비어있는 Optional 생성 (명시적으로 값이 없음을 표현)
        Optional<String> optional3 = Optional.empty();

        // 3. Optional 값 확인 메서드
        // 1) isPresent(): 값이 존재하면 true, 존재하지 않을 경우 false
        // 2) isEmpty(): 값이 존재하면 false, 존재하지 않을 경우 true
        System.out.println(optional1.isPresent()); // true
        System.out.println(optional1.isEmpty());  // false

        System.out.println(optional2.isPresent()); // false
        System.out.println(optional2.isEmpty()); // true

        // 4. Optional 값 추출 메서드
        // .get()
        //  >> 값이 없는 상태(null) 에서 호출시 예외 발생
        System.out.println(optional1.get()); // Hello Optional!
      // System.out.println(optional2.get()); // NoSuchElementException

        // 5. Optional 기본값 처리
        //      >> 값을 확인하고 존재하면 반환, 존재하지 않으면(빈 Optional 이면) 경우에 따라 반환 또는 예오ㅣ 발생
        // 1) .orElse(T other) : 값이 없을 경우 기본값 (other) 반환
        // 2) .orElseGet(Supplier<T>): 값이 없을 경우 함수형 인터페이스로 값을 생성하여 반환
        // 3) .orElseThrow(Supplier<Throwable>): 값이 없을 경우 예외 발생

        // cf) Supplier<T>: 공급하다
        //      - T 타입의 값을 생성하여 반환

        System.out.println(optional2.orElse("기본값 반환"));
        System.out.println(optional2.orElseGet(() -> "값을 생성하여 반환"));

        try {
            optional3.orElseThrow(() -> new Error("값이 없을 경우 예외 발생"));
           // optional3.orElseThrow(() -> new Exception("예외 발생")); Exception 발생시키면 catch 매개변수로 Exception 으로 바꿔줘야함
        } catch (Error e) {
            System.out.println("예외 발생했습니다." + e.getMessage());
        }

        System.out.println("정상적인 코드 흐름");


        // cf) Optional 사용시 주의 사항
        // 1) 필드에 사용 X
        // 2) 메서드 매개변수로 사용 X
        //      >> "반환값"으로 사용 (메서드 호출결과가 null 일수 있는 경우에만)
        // 3) 값이 반드시 존재해야 하는 경우 사용 X
        //      >> null 방지에 대한 필수값은 직접 값을 반환하고 null 여부 확인


    }
}
