package org.example.chapter08;

// == 추상화  === //

// 1. 추상 클래스 정의
// : 미완성 클래스, 일부 구현이 누락된 불완전한 클래스
// >> 자체로 인스턴스를 생성할 수 없음..
// >> 다른 클래스가 상속받아 완성해야만 사용가능 !!

// 2. 추상 클래스 특징
// 1) 자체로 인스턴스 생성불가
// 2) 반드시 하나 이상의 추상 메서드를 포함해야함 (여러개 가능, 하나이상의 추상메서드 있으면 일반 메서드도 선언가능)

// 3. 추상 클래스 구현 방법
// : 클래스 선언 앞에 'abstract' 키워드 사용
// abstract class AbstractClass명 {}

// 4. 사용 목적
// : 확장성 제공을 위해 사용
//  - 자식 클래스가 공통된 기능을 공유 + 고유 기능을 구현하도록 강제함.

// cf) 다중 상속이 불가능함 - 하나의 extends 만 가능 (여러개의 부모 클래스X)

// 5. 추상 메서드
// : 메서드의 선언부만 존재함. 구현부가 없는 메서드를 말함
// - 자식 클래스에서 해당 메서드를 반드시! 구현하도록 강제하는 역할
// - abstract 키워드 사용 + 구현부 {} 대신 세미콜론(;) 사용하여 선언 마침

// cf) 메서드 오버라이딩 VS 추상 메서드
// - 추상메서드: **반드시** 자식 클래스에서 오버라이딩 해야함 (구현부를 명시해야함)
// - 일반 메서드: 필요에 따라 오버라이딩하면 됨


abstract class Human {
    //추상 메서드 1개 이상 무조건 있어야함.
    abstract  void work();  // 구현부{} 없이 ; 로 종료
}

class Police extends Human {
    @Override
    void work() {   // 추상 메서드 구현
        System.out.println("경찰은 치안유지 업무를 담당합니다.");
    }
}

class Student extends Human {
    @Override
    void work() {
        System.out.println("학생은 공부를 합니다.");
    }
}


abstract class Lion {
    abstract void mane();
}

abstract class  Tiger {
    abstract void stripe();
}

// cf) 다중 상속이 불가능함.
//class Liger extends Lion extends Tiger {
//
//}

// 4. 추상 클래스 예시
abstract class Animal {
   abstract void makeSound();

   // 추상메서드 1개 이상 있으면 일반메서드도 선언가능함.
   void eat() {
       System.out.println("동물은 먹이를 먹습니다");
   }
}

class Dog extends Animal {

    // 추상메서드(makeSound) 는 반드시 재정의
    @Override
    void makeSound() {
        System.out.println("멍멍");
    }

    // 일반 메서드는 선택정 재정의
    @Override
    void eat() {
        System.out.println("강아지는 개껌을 먹습니다.");
    }

    void bark() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("야옹");
    }
    //일반 메서드는 재정의안해도 됨.
}

public class A_Abstract {
    public static void main(String[] args) {
       // Human human = new Human();  -> 추상클래스이기에 직접적인 인스턴스화 할 수 없음.
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.makeSound();
        dog.eat();
        dog.bark();

        cat.makeSound();
        cat.eat();  // 부모의 메서드 결과가 호출(Cat 은 Animal 을 상속받았으므로)

        Animal dog1 = new Dog();
        // 추상 클래스 또한 클래스 타입으로 활용 가능
        // 단, 자식만이 가진 멤버(필드, 메서드)에는 접근 불가
        dog1.eat(); //강아지는 개껌을 먹습니다. -> 오버라이딩 된 결과가 출력(자식만의 메서드 접근 X)
        dog1.makeSound();
      //dog1.bark();  -> 자식만의 메서드 접근 X
    }
}
