package org.example.chapter04;

// 클래스 변수 VS 인스턴스 변수

// 1. 형태
// - 클래스 변수: static 키워드가 데이터 타입 앞에 명시
// - 인스턴스 변수: 일반 변수 선언

// 2. 선언 위치
// : 모두 클래스 영역 내에서 선언

// 3. 생성 시기 & 사용 시기
// - 클래스 변수: 클래스가 Method Area 영역에 할당될때 사용 가능 / 객체 생성 이전에도 사용가능
// - 인스턴스 변수: 인스턴스가 생성될때만 / 객체 생성 이후에만 사용 가능

// 4. 호출 방법
// - 클래스: 클래스명.변수명;
// - 인스턴스: 객체명.변수명;

class Example {
    int instanceValue;
    static int classValue;
}

class Counter {
    static int count = 0;  // 필드를 생성시 초기화할때 이렇게 선언. 주로 고정적인 static 에 사용

    Counter() {
        count++;
    }
}

public class F_Field {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        Counter c4 = new Counter();
        Counter c5 = new Counter();

        System.out.println(Counter.count);

        new Counter();
        new Counter();
        new Counter();

        System.out.println(Counter.count);
    }
}
