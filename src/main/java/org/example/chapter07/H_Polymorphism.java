package org.example.chapter07;

// == 다형성 == //
// : 많은 형태를 가질 수 있는 특성
// - 하나의 객체가 여러 타입의 인스턴스로 표현될 수 있는 특성

// 1) 다형성을 구현하는 3요소
// - 상속
// - 메서드 오버라이딩
// - 업캐스팅

// 2) 다형성의 표현
// - 하나의 부모 타입 참조 변수로 여러 자식 객체를 참조
// - 각 객체는 각자의 방식대로 동작(= 메서드 오버라이딩)

// Vehicle
class Vehicle {
    void depart() {
        System.out.println("운송수단이 출발합니다.");
    }
}

class Bus extends Vehicle {
    @Override
    void depart() {
        System.out.println("버스가 출발합니다. 자리에 앉아주세요");
    }
}

class Subway extends Vehicle {
    @Override
    void depart() {
        System.out.println(" 지하철 문이 닫힙니다. 열차가 출발합니다.");
    }
}

class Bird {
    void fly() {
        System.out.println("새가 날개짓을 합니다.");
    }
}
public class H_Polymorphism {
    public static void main(String[] args) {
        // == 다형성 적용 == //
        // : 부모클래스 타입의 참조변수로 자식 클래스 객체를 참조
        // : 업캐스팅
        Vehicle vehicle = new Vehicle();
        Vehicle bus = new Bus();
        Vehicle subway = new Subway();

        //Vehicle bird = new Bird();
        Bird bird = new Bird();
        // Vehicle vBird = (Vehicle) bird; 상속이 전제되어야함.

        // cf) instanceof 연산자
        // 작성법: 참조변수값 instanceof 클래스타입
        // > 해당 객체가 특정 클래스의 인스턴스 인지 또는 그 클래스를 상속받은 자식 클래스의 인스턴스인지 확인
        // > boolean 타입으로 반환
        // 업캐스팅된 객체를 다운 캐스팅할 경우, instanceof 클래스타입의 객체가 맞는지 확인후, 캐스팅

        if(subway instanceof Vehicle){  // subway 객체가 Vehicle 인스턴스 이면서, Vehicle을 상속받은 인스턴스 일 경우
            subway.depart();
        }

        if(bus instanceof Vehicle) {
            bus.depart();
        }

        if(vehicle instanceof Bus) {
            System.out.println("운송수단은 버스입니다.");
        } else {
            System.out.println("운송수단은 버스가 아닙니다");
        }

        // +) instanceof 연산자가 true 를 반환하는 경우,
        // 해당 클래스 타입으로 형 변환이 가능함을 의미
        if(bus instanceof Bus) {
            Bus myBus = (Bus) bus;
        }

        // !! Best Practice !! //
        // 1. instanceof 연산자 불필요한 경우에는 남용금지
        // 2. 다운캐스팅은 반드시 instanceof 확인이 필요함
        // 3. 인터페이스 || 추상클래스와 함께 사용시, 다형성의 특징이 증가함.
    }
}
