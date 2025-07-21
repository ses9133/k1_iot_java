package org.example.chapter14;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
    === 람다식 ===
    : 함수형 인터페이스(@FunctionalInterface)를 간결하게 구현하는 코드식
    >> 딱 한가지 일을 처리하는 메서드

    1. Predicate<T>(판단하다)
    : 입력값을 받아 조건을 검사하는 데 사용
    : 메서드
         - boolean test(T t) : 주어진 입력 값이 조건을 만족하면 true, 그렇지 않으면 false 반환
         - and(Predicate other), or(Predicate other), negate() : Predicate 조합에 사용
        cf) negate : 부정하다 (현재의 결과를 역전)

     @FunctionalInterface
     interface Predicate<T> {
            boolean test(T t);
     }

    2. Function<T, R> (변환하다)
    : 입력값을 받아 특정 연산을 수행한 후, 결과(R)를 반환
    : 메서드
         - R apply(T t): 입력값을 받아 변환한 값을 반환
         - andThen(Function after): 현재 결과를 다른 Function 입력으로 연결
         - compose(Function before): 다른 Function 의 결과를 현재 입력으로 연결

     @FunctionInterface
     interface Function<T, R> {
        R apply(T t);
     }

     3. Consumer<T> (소비하다)
     : 입력값을 받아 소비(출력 또는 상태 변경)하는데 사용
     : 메서드
        - void accept(T t) : 입력값을 소비
        - andThen(Consumer after): 연속적인 소비작업을 위해 사용

    @FunctionalInterface
    interface Consumer<T> {
        void accept(T t);
    }

 */
public class E_Lambda {
    public static void main(String[] args) {
        // == Predicate == //
        System.out.println("=== Predicate ===");

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println(isEven.test(10));
        System.out.println(isEven.test(11));
        System.out.println(isPositive.test(-1));

        //  논리값에 대한 연산을 and, or, negate 로 가능 : 논리 연산자처럼 조건을 연결
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        System.out.println(isEvenAndPositive.test(4));
        System.out.println(isEvenAndPositive.test(-4));

        // == Function == //
        System.out.println("=== Function ===");
        // 매개변수 1개 : () 생략가능, 구현부 1줄 : {}, return 생략가능
        Function<String, Integer> stringLength = s -> s.length();
        Function<Integer, Integer> square = n -> n * n;
        Function<String, String> upperString = s -> s.toUpperCase();
        System.out.println(stringLength.apply("aaa"));
        System.out.println(square.apply(3));
        System.out.println(upperString.apply("nice to meet you"));

        Function<String, Integer> lengthAndSquare = stringLength.andThen(square);
        // 문자열의 길이값을 인자로 받아 제곱
        System.out.println(lengthAndSquare.apply("abcd"));

        System.out.println("=== Consumer ===");
        Consumer<String> printMessage = msg -> System.out.println(msg);
        Consumer<String> printLength = msg -> System.out.println(msg.length());

        printMessage.accept("안녕하세요");
        printLength.accept("abcde");

        Consumer<String> combinedConsumer = printMessage.andThen(printLength); // printMessage 호출하고 , printLength 도 연속적으로 호출
        combinedConsumer.accept("123");// 123 3
        
    }
}
