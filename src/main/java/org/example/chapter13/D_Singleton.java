package org.example.chapter13;

// == 싱글톤 패턴 == //
// : 소프트웨어 설계 패턴 중 하나
// - 클래스의 인스턴스가 하나만 생성되도록 보장
// - 해당 클래스의 인스턴스에 전역적으로 접근이 가능하도록 하는 패턴

// 1) 싱글톤 패턴 특징
// - 클래스의 인스턴스가 단 하나만 존재
// - 인스턴스에 대해 전역 접근을 제공
// - 주로 설정 정보 관리 객체, 공유 자원 관리 객체, 로그 객체 등에서 사용

// 2) 사용 목적
// - 객체의 유일성을 보장
// - 자원의 절약

// 3) 장단점
// - 장점
//  : 중복 인스턴스 방지(메모리 절약)
//  : 글로벌 상태 유지
//  : 일관된 상태 유지
// - 단점
//  : 결합도 증가 - 여러 클래스가 같은 인스턴스 공유시, 하나가 변경될 때 다른 곳에 영향을 미칠 수 있다.
//  : 테스트에 어려움 있음 - 전역 상태를 사용하는 특성으로 인해

// 4) 구현 방법 (필드값 static, 생성자 private, 인스턴스 담당 메서드 public static)
class Singleton {
    // 필드값: static 으로
    private static Singleton instance;

    // 생성자: private
    //  >> 외부에서 직접적인 인스턴스화를 불가능하게 함
    //  >> 반드시 해당 클래스 내에서만 인스턴스화하게끔
    private Singleton() {

    }

    // 싱글톤 패턴의 전역 접근성을 제공하는 메서드 정의 (인스턴스화 담당)
    public static Singleton getInstance() {
                        //주로 getInstance(); 많이 씀
        if(instance == null) {
            // 필드가 초기화 이전이면(아직 인스턴스화가 되지 않았으면)
            instance = new Singleton();
        }

        return instance;
        // 1) if 조건문이 true: 인스턴스화된 객체를 반환
        // 2) if 조건문이 false: 기존 필드에 저장된 객체를 반환

        // >> 1이든 2이든 객체는 반드시 하나가 존재하게 됨
    }
}

// == 교장 선생님 클래스 === //
// : 학교에 교장선생님은 한 명만 존재한다!
class SchoolPrincipal {
    // 유일한 객체를 저장할 변수 : 클래스 그자 체의 객체값을 저장
    private static SchoolPrincipal instance;

    // 1. 생성자
    private SchoolPrincipal() {
        System.out.println("교장 선생님 객체 생성");
    }

    // 2. 메서드
    public static SchoolPrincipal getInstance() {
        if(instance == null) {
            instance = new SchoolPrincipal();
        }
        return instance;
    }

    public void announce() {
        System.out.println("교장선생님이 발표합니다.");
    }
}

class Exapmle {
}

public class D_Singleton {
    public static void main(String[] args) {
        // 처음에는 instance == null
        SchoolPrincipal principal1 = SchoolPrincipal.getInstance();

        // 객체가 생겼으니, 기존의 instance 주소를 반환
        SchoolPrincipal principal2 = SchoolPrincipal.getInstance();
        SchoolPrincipal principal3 = SchoolPrincipal.getInstance();
        SchoolPrincipal principal4 = SchoolPrincipal.getInstance();

        System.out.println(principal1);
        System.out.println(principal2);
        System.out.println(principal3);
        System.out.println(principal4); // org.example.chapter13.SchoolPrincipal@3b07d329 -> 다 동일한 주소값 가지고 있음

        Exapmle exapmle1 = new Exapmle();
        Exapmle exapmle3 = new Exapmle();
        Exapmle exapmle2 = new Exapmle();
        Exapmle exapmle4 = new Exapmle();

        System.out.println(exapmle1);
        System.out.println(exapmle2);
        System.out.println(exapmle3);
        System.out.println(exapmle4); // example 주소는 다 다름 (싱글톤 패턴이 아니기때문)

        System.out.println(principal1 == principal2); // true.
        principal1.announce();

    }
}
