package org.example.chapter12.view;

// 학교 급식
// Model(급식표), View(화면), Controller(영양사)
/**
 * 학생 >> view(화면클릭) >> controller 가 급식 업데이트 >> model (급식표) 조회(DB) >> controller가 view 에 해당 내용 전달 >> view 출력
 * */

// model
class LunchMenu {
    private String menu;

    public String getMenu() {
        return menu;
    }
    public void setMenu(String menu) {
        this.menu = menu;
    }
}

// View
class LunchView {
    public void display(String menu) {
        if(menu == null || menu.isBlank()) {
            System.out.println("오늘은 급식이 없습니다.");
        } else {
            System.out.println("오늘의 급식메뉴: " + menu);
        }
    }
}

// Controller
class LunchController {
    private LunchView view;
    private LunchMenu model;

    public LunchController(LunchView view, LunchMenu model) {
        this.view = view;
        this.model = model;
    }

    // model 에 데이터 저장
    public void setLunchMenu(String menu) {
        model.setMenu(menu);
    }

    // model 통해 저장한 데이터를 뷰로 전달
    public void updateView() {
        String menu = model.getMenu();
        view.display(menu);
    }

    public void studentRequestView() {
        System.out.println("[학생요청] 오늘 메뉴가 뭐에요 ? ");
        updateView();
    }
}
public class MVC {
    public static void main(String[] args) {
        LunchMenu model = new LunchMenu();
        LunchView view = new LunchView();

        LunchController controller = new LunchController(view, model);
//        controller.setLunchMenu("떡볶이");
//        controller.updateView();
//
//        controller.studentRequestView();

        controller.setLunchMenu("");
        controller.studentRequestView();
    }
}
