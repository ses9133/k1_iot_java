package org.example.chapter06;

// === 상속(Inheritacne) == //
// : 한 클래스의 속성과 메서드를 다른 메서드가 물려받는 것
// - 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것
// - 코드의 재사용성, 중복 제거(프로그램의 생산성 향상)

// 상속 구현 방법
// : extends(확장하다) 키워드 사용
// : class 자식클래스 extends 부모클래스 {}

class Parents {

}
class Child extends Parents {

}

// cf) 명칭
//      상속해주는 클래스(Parent) - 조상, 부모, 상위, 기반, 슈퍼 클래스라고도 불림
//      상속받는 클래스(Child) - 자손, 자식, 하위, 파생, 서브 클래스라고도 불림

// == 동물 클래스 == //
class Animal {
    String name;
}

class Dog extends Animal {
    // 부모 클래스의 속성과 메서드를 모두 상속 받은 상태임(생략된 것과 같음)
    // String name; ->  굳이 명시X (명시하는 경우에 필드 사용시, this. 인지 super. 인지 명시해야함)

    // 클래스의 확장
    // : 부모가 가지지 않은 필드나 메서드 정의 가능
    void bark() {
        System.out.println("멍멍!");
    }
}

// == TV 클래스 == //
class Tv {
    boolean power;  // on/off
    int channel;

    void setPower() {
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }
}

class SmartTv extends Tv {
    boolean ott;    // ott 플랫폼 전원 상태(on/off)

    void displayOtt(String platform) {
        if(ott) { // ott 가 true 면 (켜져있으면)
            System.out.println(platform);
        }else {
            System.out.println("OTT 연결이 되지 않았습니다.");
        }
    }
}
public class B_Inheritance {
    public static void main(String[] args) {
        Dog choco = new Dog();
        choco.name = "초코"; // 부모(Animal) 클래스를 상속받았기때문에 부모 클래스의 필드 (String name) 사용 가능
        System.out.println(choco.name);
        choco.bark();

        // == Tv 객체 생성 == //
        Tv tv1 = new Tv();  // 필드의 경우, 자동 초기화됨(기본 자료형은 boolean - false, int (0), ,, 초기화/ 참조변수 - null)
        tv1.power = true;
        tv1.channelUp();
        tv1.channelUp();
        tv1.channelUp();
        System.out.println(tv1.channel);
        tv1.channelDown();
        System.out.println(tv1.channel);

        SmartTv smartTv1 = new SmartTv();
        smartTv1.power = true;
        smartTv1.channelDown();
        smartTv1.channelDown();
        smartTv1.channelDown();
        smartTv1.channelDown();
        System.out.println(smartTv1.channel);

        smartTv1.displayOtt("neflix");
        smartTv1.ott = true;
        smartTv1.displayOtt("neflix");

        // tv1.ott = true;
        // -> 부모는 자식의 기능과 행위를 전달받지 못함.
    }
}
