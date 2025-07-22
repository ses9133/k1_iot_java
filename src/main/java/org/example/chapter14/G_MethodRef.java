package org.example.chapter14;

/*
    === 메서드 참조 ===
    : 람다 표현식을 더 간단하게 작성하기 위한 문법
    - 메서드 호출만 하는 단순한 람다일 경우, 메서드 이름만으로 표현 가능

    === 메서드 참조 종류 ===
    1. 정적 메서드 참조
    - 클래스의 static 메서드 참조
    - 클래스명.static메서드(); ---> 클래스명::static메서드; (콜론 2개 추가, 중괄호 없애기)

    2. 인스턴스 메서드 참조
    - 객체를 반드시 생성하여 사용하는 메서드
    - 특정 객체의 인스턴스 메서드를 참조
    - 객체명.메서드(); ---> 객체명::메서드;

    3. 생성자 메서드 참조
    - 객체 생성용 생성자 참조
    - new 클래스명(); ---> 클래스명::new

    4. 임의 객체의 인스턴스 메서드
    - 특정 객체가 아닌 여러 객체에 공통된 인스턴스 메서드를 사용 할 때
    ex) 모든 객체가 Object 내의 인스턴스 메서드를 포함
    - 클래스명::인스턴스메서드;

 */

import java.util.function.Function;
import java.util.function.Supplier;


class StaticMethod {
    // 정적 메서드
    static int doubleValue(int x) {
        return x * 2;
    }
}

class Person {
    private String name;

    public Person() {
        this.name = "이름 미상";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class G_MethodRef {
    public static void main(String[] args) {

        // 1. 정적 메서드 참조
        // 1) 람다 표현식
        Function<Integer, Integer> doubleLambda = x -> StaticMethod.doubleValue(x);

        // 2) 메서드 참조
        Function<Integer, Integer> doubleLambdaRef = StaticMethod::doubleValue;
        System.out.println(doubleLambda.apply(5));
        System.out.println(doubleLambdaRef.apply(5));

        // 2. 인스턴스 메서드 참조
        // cf) 문자열 객체의 메서드 사용
        //      - Object 를 상속받는 String 클래스는 선언시 객체 생성이 이루어짐
        //      >> String 클래스 내부 인스턴스 메서드 사용 가능
        String hello = "Hello";
        // 1) 람다 표현식
        Supplier<String> toUpperLambda = () -> hello.toUpperCase();

        // 2) 메서드 참조
        // 이미 생성된 객체의 메서드를 참조
        Supplier<String> toUpperLambdaRef = hello::toUpperCase;
        System.out.println(toUpperLambda.get());
        System.out.println(toUpperLambdaRef.get());

        // 3. 생성자 참조
        // 1) 람다 표현식
        Supplier<Person> personLambda = () -> new Person("이승아");
        Supplier<Person> personLambda2 = () -> new Person(); // 매개변수가 없는 생성자일 경우에만 메서드 참조 가능!!!
        // 2) 메서드 참조
        // : 매개변수가 없는 생성자일 경우에만 사용가능!!!
        Supplier<Person> personLambdaRef = Person::new;

        Person p1 = personLambda.get();
        Person p2 = personLambdaRef.get();

        System.out.println(p1.getName());
        System.out.println(p2.getName());

        // 4. 임의 객체 인스턴스 메서드 참조
        String[] names = { "seungah", "dokyeong", "seungbom" };

        // 1) 람다 표현식 Function<String, String> toUpperFunc = s -> s.toUpperCase();
        // 2) 인스턴스 메서드 참조
        Function<String, String> toUpperFunc = String::toUpperCase;

        for(String name: names) {
            // 호출 시점(apply) 에 매개변수로 들어온 객체의 메서드 호출
            String upper = toUpperFunc.apply(name);
            System.out.println(upper);
        }
    }
}
