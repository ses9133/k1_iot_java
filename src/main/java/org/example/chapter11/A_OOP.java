package org.example.chapter11;

// == OOP == //
// == SOLID 원칙 == //
// : 객체지향 프로그래밍의 5가지 소프트웨어 개발 원칙
// - SRP, OCP, LSP, ISP, DIP
// - 소프트웨어 설계에서 유지보수성과 확장성을 높임
// >> 다양한 디자인 패턴이 SOLID 설계 원칙에 따라 만들어짐

// cf) 디자인 패턴
//  : 소프트웨어 개발 과정에서 자주 발생하는 문제들에 대한 일반적인 해결책

// cf) SOLID 원칙 적용시 주의점
//  : 적용 순서 X
//  : 모두 적용할 필요 없음
//  : 서로 독립적인 개념 X - 개념적으로 연관되어있는 원칙
//  - 상속, 캡슐화, 추상화, 다형성은 OOP 의 4가지 특성!

// 1. SRP(Single Responsibility Principle, 단일 책임 원칙)
//  - 클래스는 단 하나의 책임만을 가져야한다
//  - 한 가지 역할(기능)만 담당 / 하나의 변화 이유만을 가져야 함
//  >> 하나의 클래스가 가지는 하나의 역할과 관련된 변경사항만 클래스에 영향을 미쳐야 함

// 1) 잘못된 설계 에시 - 하나의 클래스가 여러개의 책임을 가짐
class SchoolHelper {
    void cleanClassroom() {
        System.out.println("교실을 청소합니다.");
    }

    void prepareLunch() {
        System.out.println("급식을 준비합니다.");
    }
}

// 2) 올바른 설계에시 - 각각의 클래스가 자신의 역할만을 담당 (유지보수와 테스트가 쉬워짐)
class Janitor {
    void cleanClassroom() {
        System.out.println("교실을 청소합니다.");
    }
}

class LunchStaff {
    void prepareLunch() {
        System.out.println("급식을 준비합니다.");
    }
}

// 2. OCP (Open-Closed Principle, 개방 폐쇄 원칙)
// : 소프트웨어 엔티티(클래스, 모듈, 함수 등)는 확장에서는 열려있어야 하고, 수정에는 닫혀있어야한다.

// 1) 잘못된 설계 에시 - 새로운 학생 유형이 생길 때마다 if 문 추가해야함(기존 코드 수정이 필요)
class LunchMenu {
    void serveLunch(String studentType) {
        if(studentType.equals("일반 학생")) System.out.println("알레르기가 없습니다.");
        else if(studentType.equals("땅콩 알레르기")) System.out.println("땅콩 알레르기가 있습니다.");
    }
}

// 2) 올바른 설계 예시 - 변화가 발생해도 LunchMenuInterface 를 구현한 클래스만 추가하면 됨 (확장만 하면 됨)
interface LunchMenuInterface {
    void serveLunch();
}

class RegularStudent implements LunchMenuInterface {
    @Override
    public void serveLunch() {
        System.out.println("일반 학생 - 알레르기가 없습니다.");
    }
}

class VegetableStudent implements LunchMenuInterface {
    @Override
    public void serveLunch() {
        System.out.println("채식 학생 - 샐러드를 제공합니다.");
    }
}

class AllergyStudent implements LunchMenuInterface {
    @Override
    public void serveLunch() {
        System.out.println("알레르기 학생 - 특별 배식구로 이동하세요");
    }
}

// >> 추상 클래스와 인터페이스를 사용하여 상속, 구현을 통한 클래스 관계 구축

// 3. LSP(Liskov Substitution Principle, 리스코프 치환 원칙)
//  : 상위 클래스의 객체를 하위 클래스의 객체로 치환하더라도 프로그램 동작이 일관되게 유지되어야함.
//  - 자식 클래스는 부모 클래스의 기능을 완전하게 대체할 수 있음
// >> 업캐스팅 상태에서 부모의 메서드 사용시 동작가능함

// 1) 잘못된 설계예시 - Student 의 동작과 InjuredStudent 가 같은 메서드를 통해 서로 다른 행동을 실행함
class Student {
    void playSoccer() {
        System.out.println("축구를 할 수 있습니다.");
    }
}

class InjuredStudent extends Student {
    @Override
    void playSoccer() {
        // 부모가 가진 기능의 일관성 X
        System.out.println("다쳐서 축구를 할 수 없습니다.");
    }
}

// 2) 올바른 설계 예시 - 부모의 activity(); 추상메서드를 각 자식의 의도에 맞게 재정의
abstract class StudentAbstract {
    abstract void activity();
}

class SoccerPlayer extends StudentAbstract {
    @Override
    void activity() {
        System.out.println("축구를 합니다.");
    }
}

class InjuredSoccerPlayer extends StudentAbstract {
    @Override
    void activity() {
        System.out.println("다쳐서 축구를 할 수 없습니다.");
    }
}


public class A_OOP {
    public static void main(String[] args) {

    }
}
