package org.example.chapter07;

// cf) 자바 패키지 또는 클래스 파일 간의 코드 연결
// : import 문을 사용

// 1) 같은 패키지 내: import 클래스파일명
// 2) 다른 패키지 내: import 패키지경로.패키지명.파일명;

//import org.example.otherPackage.OtherClass;
//import org.example.otherPackage.PublicClass;

import org.example.otherPackage.*;
// : * 기호는 전체를 의미
// - 다만, 프로그램의 향상성을 위해 권장하지 않음

// == 접근 제한자(제어자) == //
// : 클래스, 변수, 메서드의 접근 범위를 제어
// - 외부로부터 데이터를 보호, 객체 간의 의존성을 최소화하는 역할
// - 코드의 보안성을 향상, 캡슐화 구현

// 1. 접근 제어자 종류
// : public, (default), protected, private
// - 생략시 default 값이 지정됨

// cf) default class DefaultClass {  -> default 키워드를 직접 명시하지 못함
//
//}

// cf) 클래스 자체에 접근 제어자를 사용 X
//      : 중첩 클래스가 아닌 경우 명시적인 접근 제어자 사용이 불가능함
//      >> 클래스 파일의 경우 작성 가능!


//protected class ProtectedClass {  -> 클래스 자체에 사용 불가!(중첩 클래스만 사용 가능)
//
//}
class Modifier {}

// 2. 접근 제어자 범위
// public > protected > (default) > private

// 1) private
// : 같은 클래스 내에서만 접근 가능
class PrivateClass {
    private int myField;
    private void myMethod() {
        System.out.println(myField);    // private 필드는 PrivateClass 내부에서만 사용 가능
    }
}

// 2) default
// : 같은 패키지 내라면 접근 가능(폴더 단위
// - 패키지 외부에서는 접근 불가능
class DefaultClass {
    int myField;
    void myMethod() {
        System.out.println(myField);
    }
}

// 3) protected . (otherPackage > OtherClass 참고)
// : 동일한 패키지 내의 모든 클래스에서 접근 가능 (default 와 동일한 점)
// : 다른 패키지에 있는 경우, 해당 클래스를 상속받은 하위 클래스에서만 접근 가능!
class ProtectedClass extends OtherClass {

    ProtectedClass() {
        // 상속받은 부모 클래스의 필드 & 메서드
        System.out.println(otherField);
        otherMethod();
    }
}

// 4) public
//  : 클래스나 패키지 위치와 상관없이 접근 가능


public class A_Modifier {

    public static void main(String[] args) {

        // 1) private
        // PrivateClass 외부에서 private 필드에 접근
        PrivateClass privateClass = new PrivateClass();
//        privateClass.myField; -> private access
//        privateClass.myMethod(); -> private access
        // : 접근 제어자는 가시성을 나타냄
        // - private 은 해당 클래스 내부에서만 접근 가능

        // 2) default
        DefaultClass defaultClass = new DefaultClass();
        System.out.println(defaultClass.myField);
        defaultClass.myField = 10;
        defaultClass.myMethod();    // 10

        // 3) protected
        ProtectedClass protectedClass = new ProtectedClass();

        // 4) public
        PublicClass publicClass = new PublicClass();
        System.out.println(publicClass.publicField);
        publicClass.publicMethod();


    }
}
