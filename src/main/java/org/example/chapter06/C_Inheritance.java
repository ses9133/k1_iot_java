package org.example.chapter06;

// == 상속에서의 생성자 == //
// : 상속받은 클래스에서 생성자를 호출하면
// >> (순서) 부모 에서 자식 순서로 호출!

// cf) 자식 클래스에서 객체 생성 시, 자식 클래스는 해당 클래스의 생성자를 통해 객체가 생성됨
//      - 자식 클래스의 생성자 호출시 **'반드시'** 부모 클래스의 생성자가 호출되어야함. (이때 생성자는 사용자 정의 생성자일 필요는 없음)
//      - 반드시 부모가 존재해야만 자식이 존재함

class A {
    A() {

    }
    A(int a) {
        //System.out.println(a); -> 생성자 내에서 타 생성자 호출시 this() 는 가장 첫줄에서 이루어져야함.
        this();
        System.out.println(a);
    }
}

class Mammal {
    String name = "Parent";

    Mammal() {
        System.out.println("빈 부모 생성자 - 인스턴스 생성");
    }

    Mammal(String name) {
        this.name = name;
    }

    void displayMammal() {
        System.out.println(name);
    }
}

class Cat extends Mammal {
    String name = "Child";

    // cf) 상속받은 자식 클래스의 경우,
    //      : 사용자 정의 부모 생성자의 호출이 없더라도,
    //        super() 라는 부모 클래스 생성자 호출 키워드가 정의되어잇음(생략되어있음)

    Cat() {
        super(); // 생략되어있어도 자동호출이 됨
        // >> Mammal 클래스 내에 매개변수가 없는 생성자를 의미
        System.out.println("빈 자식 생성자 - 인스턴스 생성");
        // 반드시 super() 먼저 호출되어야함.
    }

    Cat(String name) {
          super(name); // Mammal 클래스에 String 변수를 매개변수로 받는 생성자 호출
        // super() 메서드는 부모 클래스의 생성자를 가져오는 키워드
        // - 부모 클래스 내에 정의된 생성자를 형태 그대로 사용
        // - 여러개의 생성자가 있는 경우 오버로딩 super() 의 형태도 다양해질수있음.


//        Mammal(String name) {
//            this.name = name;
//        }

       // this.name = name;
    }


    void displayCat() {
        // 해당 클래스가 가진 인스턴스 변수에 접근: this.
        // > 생략가능(지역변수와 충돌이 나지 않는경우에만)
        System.out.println("자식 이름: " + name);
        System.out.println("자식 이름:" + this.name);

        // 부모 클래스가 가진 인스턴스 변수에 접근 : super.
        // >> 생략 불가!
        System.out.println("부모이름: " + super.name);
    }
}

// cf) super.
//      : 부모 클래스로 생성된 객체 그 자체
//      - 부모 클래스 내의 필드와 메서드에 접근(. 연산자를 통해)
//      >> super.필드명; / super.메서드명();
//      >> super(); (부모클래스 내의 생성자 호출)

public class C_Inheritance {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        // 빈 부모 생성자 - 인스턴스 생성
        // 빈 자식 생성자 - 인스턴스 생성

        Cat cat2 = new Cat("나비");
        System.out.println("=====");
        System.out.println(cat2.name); // child

        cat2.displayCat();
//        자식 이름: Child (name)
//        자식 이름: Child (this.name)
//        부모이름: 나비  (super.name)

        cat2.displayMammal(); // 나비

    }
}
