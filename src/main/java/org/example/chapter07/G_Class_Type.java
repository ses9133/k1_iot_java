package org.example.chapter07;

// == 자바의 데이터 타입 == //
// 1) 기본 자료형
//      - 자료 형 변환
//      - 자동 형 변환(묵시적), 강제 형 변환(명시적)
// 2) 참조 자료형
//      - 클래스 타입 형 변환
//      - 자동 타입 변환 & 강제 타입 변환
//      >> 자료형 변환보다 가능한 범위가 좁음
//      >> 상속 관계에 있는 클래스 사이에서만 변환이 가능함
class G_Parent {
    void displayInfo() {
        System.out.println("부모 클래스입니다.");
    }
}

class G_Child extends G_Parent {
    @Override
    void displayInfo() {
        System.out.println("자식 클래스입니다.");
    }

    void childMethod() {
        System.out.println("자식 클래스만이 가지는 메서드입니다.");
    }
}

public class G_Class_Type {
    byte a = 1;
    short b = a;
    char c = (char) b;  // 기본 자료형은 타입의 체계가 달라도 변환 가능

    public static void main(String[] args) {
        // 1. 자동 타입 변환 (업캐스팅)
        //  : 자식 객체를 부모 클래스 타입으로 변환
        // > 직접 명시 X, 자동으로 타입 변환이 발생

        // 1) 자식 객체를 생성하면서 즉시 부모 타입으로 변환하여 저장
        G_Parent childObject = new G_Child();
        System.out.println("1)");
        childObject.displayInfo();
        //  childObject.childMethod();
        // cf) 자동 형 변환(업캐스팅) 의 경우, 해당 객체는 보존되면서 부모 객체처럼 사용됨
        //    >> 두 클래스 간의 공통된 특성이 아닌 경우, 자식만의 기능은 사용 불가!

        // 2) 이미 생성된 객체를 부모 타입으로 변환
        G_Child childObject2 = new G_Child();
        childObject2.displayInfo();
        childObject2.childMethod();

        // 작성법: 부모클래스 객체변수명 = 자식객체변수;
        G_Parent parentObject = childObject2;   // 업캐스팅 과정
        parentObject.displayInfo();
        //parentObject.childMethod();

        System.out.println("==== 다운 캐스팅 ====");
        // 2. 강제 타입 변환(다운 캐스팅)
        // : 부모 클래스 타입으로 변환된 객체(= **업캐스팅이 전제**)를 다시 자식 클래스 타입으로 변환하는 것
        // - 자식 클래스에만 정의된 멤버에 다시 접근 가능하도록 하게 함

        // 작성법: 자식타입 객체변수명 = (자식타입) 부모객체;
        G_Child g_child = (G_Child) parentObject;
        g_child.displayInfo();
        g_child.childMethod();

        // cf) 클래스 타입 변환시 주의점
        // : 반드시 상속 관계와 객체의 실제타입을 확인해야함
        // >> 잘못된 캐스팅은 Exception 예외가 발생함.



    }
}
