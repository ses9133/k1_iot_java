package org.example.chapter12;

/*
    == MVC 패턴 ==
    : Model, View, Controller
    - 사용자가 인터페이스를 설계하는 소프트웨어 디자인 패턴 중 하나
    - 세 가지 구성 요소로 나누어 개발을 진행(역할 분담)

    cf) 디자인 패턴: 소프트웨어 디자인 과정에서 자주 발생하는 문제들에 대한 일반적인 해결책

    1. Model
        : 애플리케이션의 데이터와 비즈니스 로직을 담당 (service, entity, repository)
        - DB, 파일 시스템, 외부 서비스와의 통신을 통해 데이터를 저장하고 검색
        - 상태 변경에 대해 View 와 Controller 에게 알릴 수 있는 매커니즘 제공
        >> View 와 Controller 의 세부 구현 사항으로부터 독립적임

    2. View
        : 사용자에게 데이터를 표시하는 방법을 정의
        - Model 의 정보를 표시, 사용자 액션을 Controller 에게 전달
        - Model 이 가진 정보를 사용자가 이해할 수 있는 형태로 변환

    3. Controller
        : 사용자의 입력을 처리하고 Model 과 View 사이의 상호작용을 관리
        - 사용자의 입력에 반응하여 Model 을 업데이트하고, 필요한 경우 View 를 새롭게 출력

    view -> controller -> model -> controller -> view
        (요청)                 (반환)         (응답)

    == MVC 패턴 장점 ==
    - 역할 분담
        : 각 구성요소가 독립적인 기능을 책임 -> 코드 관리 & 확장 용이

    - 유지보수 용이
        : 애플리케이션의 비즈니스 로직과 UI 가 분리되어 유지보수가 쉬움

    == MVC 패턴 단점 ==
    - 복잡성 증가
        : 간단한 애플리케이션 구현에는 MVC 패턴 구조가 복잡성을 증가시킴
    - 학습 곡선 높음
        : 이해하고 사용하기까지 일정한 학습 필요

    == MVC 패턴의 작동원리 ==
    - View >> Controller >> Model >> Controller >> View

    cf) Spring: 자바 기반 웹 프레임워크
        >> Spring Boot(Spring MVC 내장)
 */

// - 학교 급식 시스템 - //
// Model: 급식표(데이터) - 급식 메뉴가 적힌 종이
// View: 칠판(화면) - 학생들이 확인하는 곳
// Controller: 영양사 선생님 - 급식표 내용을 업데이트하고, 칠판에 알려주는 역할

// 동작 흐름
// 학생(사용자) >> View(화면 클릭) >> Controller(영양사) >> Model(급식표) 조회 >> Controller(영양사)가 View (칠판)에 전달 >> View

// 1. Model: 데이터를 저장하는 역할
class LunchMenu {
    private String menu;

    public String getMenu() {
        return menu;
    }
    public void setMenu(String menu) {
        this.menu = menu;
    }
}

// 2, View: 데이터를 보여주는 역할
class LunchView {
    public void displayMenu(String menu) {
        if(menu == null || menu.isBlank())  System.out.println("오늘은 급식이 없습니다.");
         else  System.out.println("오늘의 급식메뉴 :" + menu);
    }
}

// 3. Controller: Model 과 View 를 연결하는 역할
class LunchController {
    private LunchMenu model;
    private LunchView view;

    public LunchController(LunchMenu model, LunchView view) {
        this.model = model;
        this.view = view;
    }

    // 모델에 데이터 저장
    public void setLunchMenu(String menu) {
        model.setMenu(menu);
    }

    // 모델데이터를 뷰에 전달
    public void updateView() {
        String menu = model.getMenu();
        view.displayMenu(menu);
    }

    public void studentRequestMenu() {
        System.out.println("[학생 요청] 오늘 급식 뭐에요?");
        updateView();
    }
}

public class MVC {
    public static void main(String[] args) {
        LunchMenu menu = new LunchMenu();

        LunchView view = new LunchView();

        LunchController controller = new LunchController(menu, view);

        controller.studentRequestMenu();

        controller.setLunchMenu("김밥, 떡볶이, 콜라");
        //controller.updateView(); // 오늘의 급식메뉴 :김밥, 떡볶이, 콜라  => 응답
        controller.studentRequestMenu();

        controller.setLunchMenu("김밥, 매운 떡볶이, 콜라");
        //controller.updateView(); // 오늘의 급식메뉴 :김밥, 매운 떡볶이, 콜라
        controller.studentRequestMenu();

        controller.setLunchMenu(""); // menu.isBlank();
        controller.studentRequestMenu();

    }
}
