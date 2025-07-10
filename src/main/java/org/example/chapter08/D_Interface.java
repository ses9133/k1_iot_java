package org.example.chapter08;

// 인터페이스
interface Flyable {
    int AVERAGE_SPEED = 100; // public, static, final 생략되어있음

    // 추상메서드: public, static 생략되어있음 (각 구현체에서 오버라이딩 해야함)
    void fly();

    // 디폴트 메서드
    default void land() {
        System.out.println("착륙합니다.");
    }

    // 정적 메서드 (오버라이딩 X, 인터페이스명으로 호출 가능)
    static int getWingCount() {
        return 2;
    }
}

class 참새 implements Flyable {
    @Override
    public void fly() {
        // 인터페이스의 필드 사용가능 (구현체이기 때문)
        System.out.println("참새의 속력은 " + AVERAGE_SPEED + "km의 평균 속도보다 느립니다.");
    }

    @Override
    public void land() {
        System.out.println("사뿐히 착륙");
    }
}

class 독수리 implements Flyable {
    @Override
    public void fly() {
        System.out.println("독수리의 속력은 " + AVERAGE_SPEED + "km의 평균 속도보다 빠릅니다.");
    }

    @Override
    public void land() {
        System.out.println("슈우우우우웅 착륙");
    }
}

public class D_Interface {
    public static void main(String[] args) {
        참새 bird1 = new 참새();
        bird1.fly();
        bird1.land();

        독수리 bird2 = new 독수리();
        bird2.fly();
        bird2.land();

        System.out.println(Flyable.getWingCount());     // 인터페이스명으로 호출가능(정적메서드)

        Flyable bird3 = new 참새();
        Flyable bird4 = new 독수리();
        bird3.fly();
        bird4.fly();

    }
}
