package org.example.chapter01;

import java.util.Scanner;   // import 문장은 파일 최상단에 위치

public class G_IO {
    public static void main(String[] args) {
        // === 자바의 기본 입출력(Input / Output) === //
        // 입력: 콘솔창을 통해 개발자로부터 입력을 받는 것
        // 출력: 콘솔창으로 데이터를 출력하는 것

        // 1. 출력
        // System.out.println(출력하고자 하는 변수 또는 상수 또는 데이터값);
        // sout + 자동 완성

        System.out.println("안녕하세요");    // ln(line): 주어진 값을 콘솔에 출력하고! 줄바꿈!
        System.out.print("두번째 수업 입니다.");
        System.out.println(20250702);
        System.out.print("자바의 입출력");
        System.out.println();
        // 2. 입력
        // : 자바 내장 기능 Scanner 객체 사용
        // - 다양한 입력 소스로부터 데이터를 읽어올 수 있는 형태
        // - System.in (콘솔 창에서 표준 입력을 받음)

        // == 자바 입력 방법 == //
        // 자바의 유용한 도구가 담긴 라이브러리 내에서 Scanner 기능을 가져오기 (import)
        //import java.util.Scanner;

        // 1) 스캐너 생성
        // Scanner 변수명 = new Scanner(System.in);

        // [우항]
        // new Scanner(입력받을 방법);
        // : 새로운 스캐너를 생성
        // - System.in: 현재 실행되고 있는 프로그램(IDE)의 콘솔에서 입력받음.

        // [좌항]
        // Scanner타입 변수명
        // : 좌항의 Scanner 는 '프린트기' 라는 대표 명사

        Scanner iotScanner = new Scanner(System.in);

        // 2) 스캐너 실행
        // - 스캐너명.next(); - 입력 내용을 문자열로 반환 ( 개행 문자 인식 X)
        // - 스캐너명.nextLine(); - 입력 후의 엔터까지 전체 라인을 문자열로 반환
        // +) 스캐너명.next데이터타입(); : 각 타입의 데이터를 입력받을 수 있음
        //      Ex) .nextInt();  .nextDouble(); 등,,

        System.out.println("나이을 입력해주세요: ");
        int age = iotScanner.nextInt();

        System.out.println("키를 입력해주세요: ");
        int height = iotScanner.nextInt();

        // == 개행문자 처리 == //
        iotScanner.nextLine(); // 버퍼 처리! ( nextInt() 후에 남아있는 개행문자 처리)

        System.out.println("이름을 입력해주세요: ");
        String name = iotScanner.nextLine();

        System.out.println("나이: " + age);
        System.out.println("키: " + height);
        System.out.println("이름: " + name);

        // cf) 개행 문자(Enter)
        // : 줄을 바꿀 때 사용되는 특수 문자
        // : 사용자가 Enter 키를 입력하면 개행문자가 입력됨.

        // 1) nextInt(), nextDouble() 은 숫자만 가져감.
        //   - next + 데이터 타입 () 은 해당 데이터만 인식!

        // 2) nextLine() 은 줄 전체를 가져감
        //      [문제 상황]
        //      - 키(height) 입력시 실제 Scanner 내부에는 키 값 + 개행 문자가 저장
        //      - nextInt() 에서 키 값만 가져가고 개행문자는 그대로 버퍼에 남김.
        //      - nextLine() 은 사용자의 입력값을 기다리지 않고 빈 문자열(개행문자)를 담고 종료시킴.

        // == 스캐너 종료 방벙 === //
        // : 스캐너 사용후 메모리 최적화를 위해 스캐너 종료
        // - 스캐너명.close();

        iotScanner.close();

        // 스캐너 종류 이후 호출시 오류 발생!
       // iotScanner.nextLine(); -> 스캐너 종료후 접근 불가 오류 발생

    }
}
