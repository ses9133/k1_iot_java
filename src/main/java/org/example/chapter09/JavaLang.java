package org.example.chapter09;

// == java.lang 패키지 == //
// : 자바 프로그램의 가장 기본적인 클래스들을 포함
// - 별도의 import 없이 사용 가능

// 1) Object 클래스
// : 자바의 모든 클래스의 최상위 클래스
// : 모든 클래스가 Object 클래스를 상속받음

// 2) Math 클래스
// : 수학 연산 및 함수를 제공하는 클래스
// - 모든 필드와 메서드가 static !! Math.메서드명(); 으로 호출

// 3) String 클래스
// : 문자열 조작을 위한 다양한 메서드를 제공

import org.example.Main;

import javax.sound.midi.Soundbank;

class MyClass extends Object {  // extends Object 생략되어있음
    private int id;
    private String name;

    public MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        // 객체의 문자열 표현을 반환
        // - 기본 구현(super): '객체 클래스명 + @ + 메모리주소' 반환
        // 오버라이딩해서 원하는 정보로 반환할 수 있게
        return "MyClass[ID: " + id + "/ NAME: " + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        // 현재 this 와 매개변수의 Object 가 동등한지 비교
        // - 두 객체의 참조값을 비교
        return super.equals(obj);
    }

    String displayInfo() {
        return "MyClass[ID: " + id + "/ NAME: " + name + "]";
    }
}

public class JavaLang {
    public static void main(String[] args) {
        System.out.println("== Object == ");
        MyClass myClass1 = new MyClass(1, "정은혜");
        System.out.println(myClass1);
        System.out.println(myClass1.toString());    // .toString() 이 생략되어있음을 알 수 있움
        System.out.println(myClass1.displayInfo());    // 이렇게 할 수도 있지만 굳이..

        MyClass myClass2 = new MyClass(1, "정은혜");

        // equals() 메서드 : 인스턴스 메서드
        System.out.println("===");
        System.out.println(myClass1.equals(myClass2));

        MyClass myClass3 = myClass1;
        System.out.println(myClass3.equals(myClass1));

        String s1 = "이승아";
        String s2 = "이승아";

        System.out.println(s1.equals(s2));
        // "문자열"의 경우 equals() 메서드가 두 문자열의 내용(값)을 비교하게됨 (주소값이 아니라)

        System.out.println("=== Math ===");
        // Math 클래스 내부의 모든 필드와 메서드는 static
        System.out.println(Math.abs(-10)); // 절대값
        System.out.println(Math.max(10, 20));
        System.out.println(Math.min(10, 20));
        System.out.println(Math.sqrt(16));  // 제곱근 반환
        System.out.println(Math.pow(2, 4)); // 2의 4제곱
        System.out.println(Math.random()); // 0.0 ~ 1.0 미만의 난수

        System.out.println("=== String ===");
        String message = "Merry Christmas!";
        System.out.println(message.length()); // 공백, 기호도 포함

        boolean isEquals = message.equals("Merry Christmas");
        System.out.println(isEquals);

        // substring(int start, int end);
        // : 시작 인덱스(포함) 부터 끝 인덱스(미포함) 미만 까지의 부분 문자열을 반환
        // - 문자열 인덱스 0 부터 시작, 공백과 기호도 인덱스 번호를 가짐
        System.out.println(message.substring(6, 15));
        System.out.println(message); // 문자열 기능을 활용해도 기본 데이터 변환 X
        // >> 문자열의 불변성

        // indexOf(String)
        // : 문자열에서 특정 문자열의 첫번째 위치를 반환
        int index = message.indexOf("Christmas");
        System.out.println(index);

        //  charAt(int)
        // : 특정 인덱스의 문자를 반환
        char c = message.charAt(6);
        System.out.println(c);

    }
}
