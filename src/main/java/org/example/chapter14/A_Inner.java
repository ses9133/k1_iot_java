package org.example.chapter14;

// chapter14
// 내부 클래스(Inner Class) 의 종류 : 익명 클래스 (Anonymous Class) ( = 람다식(Lambda))
// +) Stream API

/*
    === 내부(중첩) 클래스 (Inner, Nested Class) ===
    : 다른 클래스 내부에 선언된 다른 클래스를 의미
    - 즉, 클래스 안의 클래스

    === 내부 클래스 사용 목적 ===
    1. 코드 가독성 향상 - 코드의 구조 파악 용이
    2. 캡슐화 강화 - 외부에 공개할 필요가 없는 클래스는 내부로 감춤
    3. 외부 클래스 멤버에 접근 - 내부 클래스는 외부 클래스의 필드와 메서드에 직접 접근이 가능

    === 내부 클래스 종류 ===
    1. (비정적, instance) 내부 클래스
        : "외부 클래스의 인스턴스"에 속함
        >> 외부 클래스 인스턴스를 먼저 생성해야함
        >> 외부 클래스의 인스턴스 멤버에 접근 가능

    2. 정적(static) 내부 클래스
        : "외부 클래스의 정적 멤버"에 속함
        >> 외부 클래스 인스턴스 없이 생성가능
        >> 외부 클래스의 "정적 멤버에만" 접근 가능 (인스턴스 멤버에 접근 X)

    3. 메서드 내부 클래스 (지역 클래스)
        : 메서드 내에서 정의된 내부 클래스
        >> 해당 메서드 내에서만 사용 가능
        >> 메서드의 지역 변수에만 접근 가능
        cf) 로컬 변수(외부 클래스의 멤버변수)가 final 인 경우에만 접근 가능

    4. 익명 클래스
        : 이름이 없는 내부 클래스
        - 주로 인터페이스나 추상 클래스의 구현에 사용
        >> 즉시 객체 생성 + 일회성 사용
 */

class OuterClass {
    private String outerField = "외부 클래스의 필드";
    static String staticField = "외부 클래스의 정적 필드";

    // 1. 비정적 내부 클래스 - 인스턴스 멤버처럼 사용
    class InnerClass {  // 내부 클래스
        void display() {
            // 외부 클래스의 인스턴스 멤버에 접근 가능
            System.out.println("외부 클래스 필드에 접근: " + outerField);

            // 외부 클래스의 정적 멤버 접근 가능 : (클래스명.) 생략 가능(OuterClass.) => 내부 필드처럼 그냥 사용가능
            System.out.println("외부 클래스 정적 필드에 접근:" + staticField);
        }
    }

    // 2. 정적 내부 클래스 - 인스턴스화 없이 사용가능
    static class StaticClass {
        void display() {
            // 외부 클래스의 인스턴스 멤버 접근 -> 접근 불가능
//            System.out.println("외부 클래스 필드에 접근: " + outerField);
            // 외부 클래스의 정적 멤버에 접근
            System.out.println("외부 클래스 정적 필드에 접근:" + staticField);
        }
    }

    // 3. 메서드 내부 클래스(지역클래스)
    void outerMethod() {
        // cf) 지역변수는 암묵적으로 final 로 간주 (생략가능)
        //      >> 재할당이 이루어지면 final 이 사라짐
        String localVar = "메서드 로컬 변수";
        localVar = "메서드 로컬 변수 값 변경";

        final String localFinalVar = "메서드 로컬 변수 (final)";

        class MethodClass {
            void display() {
              //  System.out.println("로컬 변수에 접근 (Final X)" + localVar); // final 또는 유사 final 필드(재할당이 안된 필드)에 접근 가능
                System.out.println("로컬 변수에 접근 (Final O)" + localFinalVar);
            }
        }

        System.out.println("외부 클래스의 메서드를 호출");

        // 지역클래스의 인스턴스화
        // : 메서드 내부에서만 쓰이기 때문에 인스턴스화도 메서드 내부에서 일어남.
        MethodClass methodClass = new MethodClass();
        methodClass.display();

    }
}

abstract class AbstractClass {
    abstract void display();
}

interface InterfaceClass {
    void something();   // 추상메서드임
}

public class A_Inner {
    public static void main(String[] args) {
        System.out.println("=== 비정적 내부 클래스 ===");
        // 사용 순서 1) 외부 클래스 인스턴스화
        OuterClass outerClass1 = new OuterClass();

        // 사용 순서 2) 외부 클래스의 인스턴스처럼 사용: 외부클래스객체명.클래스호출
        //      >> 외부클래스타입.내부클래스타입 변수명 = 외부클래스객체명.new 내부클래스();
        OuterClass.InnerClass innerClass = outerClass1.new InnerClass();
        innerClass.display();

        System.out.println("=== 정적 내부 클래스 ===");
        // 1) 외부 클래스의 인스턴스화 없이 사용가능
        //     >> 외부클래스타입.내부클래스타입 변수명 = new 외부클래스명.내부클래스명();
        OuterClass.StaticClass staticClass = new OuterClass.StaticClass();
        staticClass.display();


        System.out.println("=== 메서드 내부 클래스 (지역 클래스) ===");
        OuterClass outerClass2 = new OuterClass();
        outerClass2.outerMethod();

        System.out.println("=== 익명 내부 클래스 ===");
//        클래스타입 변수명 = new 클래스명() {
//              메서드 구현 (추상클래스/인터페이스의 추상 메서드)
//        };

        AbstractClass abstractClass1 = new AbstractClass() {
            @Override
            void display() {
                System.out.println("익명 내부 클래스 - 추상 클래스 1");
            }
        };  // ; 세미콜론필수
        abstractClass1.display();

        AbstractClass abstractClass2 = new AbstractClass() {
            @Override
            void display() {
                System.out.println("익명 내부 클래스 - 추상 클래스 2");
            }
        };
        abstractClass2.display();

        System.out.println(abstractClass1 == abstractClass2); // false

        // 클래스 정의가 외부에서 재사용될 필요가 없거나, 단 한번의 사용 목적에 유용

        InterfaceClass interfaceClass = new InterfaceClass() {
            @Override
            public void something() {
                System.out.println("안녕하세요 인터페이스로 구현한 익명 클래스입니다.");
            }
        };

        interfaceClass.something();
    }
}
