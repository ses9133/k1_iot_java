package org.example.chapter06;

// === 생성자(Constructor) === //
// : 객체(인스턴스)가 생성될 때 호출되는 인스턴스 초기화 메서드

// - 생성자 조건
//      : 클래스명과 동일한 이름을 사용
//      : 리턴값이 없는 메서드 형식 (void 타입 생략되어있음)

// '컴파일러가 제공하는 기본 생성자'
// : 클래스에 생성자가 없으면 자동 생성되는 빈 생성자
//  >> 매개변수 X, 아무런 작업도 하지 않음(구현부 내의 코드가 없음)

class Example1 {
    int value;

    // 기본 생성자 생략되어있음
//    Example1() {
//
//    }
}

class Example2 {
    int value;

    // 사용자 정의 생성자
    // : 컴파일러가 자동으로 기본 생성자를 제거
    Example2(int value) {
        this.value = value;
    }

    // 빈 생성자를 직접 명시해야만 사용 가능
    Example2() {

    }
}

class Car {
    String color;
    String gearType;
    int door;

    // 기본 생성자
    Car() {

    } // 차를 생성한 뒤에 필드값 초기화

    // 사용자 정의 생성자
    Car(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    Car(String color){
        // cf) this 키워드
        // 1) 객체 자신
        //      >> this.필드명;
        //      >> 자신의 필드에 접근 가능
        // 2) 객체 내의 생성자 호출
        //      >> this(); - this 내부의 인자 인자형태를 컴파일러가 자동 분석하여 해당하는 생성자로 연결됨
        //      >> 생성자 이름으로 클래스명 대신 this

        // door = 5; -> 생성전에 필드값 변경하면 오류남
        this(color, "auto", 4);
        // cf) 사용자 정의 생성자 내에서 타 생성자 호출시,
        //      , 반드시 !!! 첫 줄에서만 사용 가능함!!! ****
        // >> 호출된 생성자가 변수값을 초기화하기 때문에, 현재 생성자가 수행하는 작업을 유지하려면 this() 생성자뒤에 작성이 되어야함.
        //  - 무의미함 방지
        door = 6;   // -> 생성(this(color, "auto", 4);)하고나서 필드값 변경할수 있음

//        this(color, "maunal", 4);
//        >> 생성자 내부에서는 타 생성자를 한 번만 호출 가능
    }
}

// this 키워드
// 1) this
//      : 인스턴스 자신을 참조
//      - 모든 인스턴스 메서드와 생성자 내부에서 사용 가능

// 2) this()
//      : 같은 클래스 내의 다른 생성자 호출
//      - 중복 코드 제거와 유지 보수성 향상에 기여

public class A_Constructor {
    public static void main(String[] args) {
        Example1 example1 = new Example1(); // 기본 생성자 - 전달한 인자 X
        Example2 example2 = new Example2(50);

        // == Car 인스턴스 생성 == //
        Car car1 = new Car();   // 기본 생성자 호출
        car1.color = "black";
        car1.gearType = "auto";
        car1.door = 4;

        Car car2 = new Car("white", "manual", 2);   // 사용자 정의 생성자 호출

        Car car3 = new Car("red");

        System.out.println(car3.color);
        System.out.println(car3.door);
        System.out.println(car3.gearType);

        // cf) 인스턴스 생성
        //      : 생성자가 인스턴스 생성 X
        //      >> new 연산자가 인스턴스를 생성 O

    }
}
