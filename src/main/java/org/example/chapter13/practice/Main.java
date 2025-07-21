package org.example.chapter13.practice;

import org.example.chapter13.practice.controller.BookController;

/**
 * MVC 패턴을 활용한 도서관리 시스템
 *
 * @Model
 *      : 도메인 객체 정의, 실제 비즈니스에서 다루는 데이터와 상태를 표현
 *     Book 클래스 (부모)
 *     Fiction, NonFiction 클래스 (자식)
 *
 * @View
 *      : 사용자에게 정보를 출력하고 입력받는 역할 (프론트 엔드)
 *      - 콘솔 기반 ( sysout & Scanner 사용)
 *      - 비즈니스 로직을 포함 XX, 사용자의 입출력만 처리
 *
 * @Controller
 *      : View 와 Service 사이를 연결하는 역할
 *      - 사용자의 입력을 받고, 적절한 비즈니스 로직을 호출하여 처리
 *      - 결과(응답)를 다시 View 에 전달
 *
 * @Service
 *      : 비즈니스 로직을 구현하는 계층
 *      - 실제 데이터 처리를 담당
 *
 * @Repository
 *      : 데이터 저장, 조회, 삭제 등의 역할을 담당
 *      - DB 와 연결 (Service 에만 연결되어 외부에서 직접 접근이 불가능)
 *
 *      [사용자] >> View >> Controller >> Service >> Repository  >> [데이터]
 *              <<      <<            <<         <<             <<
 *
 */

public class Main {
    public static void main(String[] args) {
        BookController controller = new BookController();
        controller.start();
    }
}
