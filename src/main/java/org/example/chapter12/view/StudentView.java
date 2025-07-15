package org.example.chapter12.view;


import org.example.chapter12.controller.StudentController;
import org.example.chapter12.dto.StudentRequestDto;
import org.example.chapter12.dto.StudentResponseDto;

import java.util.List;
import java.util.Scanner;

/**
 * 사용자와 상호작용 할 수 있는 메뉴를 표시
 *      - 각 요청에 따라 controller 에게 요청값과 행위를 전달
 * */

public class StudentView {
    private final Scanner sc;
    private final StudentController controller;

    public StudentView(Scanner sc, StudentController controller) {
        this.sc = sc;
        this.controller = controller;
    }

    public void showMenu() {

        while(true) {

            try {
                System.out.println("=== 학생 관리 시스템 ===");
                System.out.println("1. 학생 추가");
                System.out.println("2. 학생 조회 (전체)");
                System.out.println("3. 학생 조회 (단건)");
                System.out.println("4. 학생 정보 수정");
                System.out.println("5. 학생삭제");
                System.out.println("6. 프로그램 종료");
                System.out.println("메뉴 선택 >> ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    // switch - case 화살표 문법 (Java 14 버전 이후 사용가능)
                    // : 기존의 case + break; 문법을 대체하여 각 case 만 실행하는 문법
                    case 1 -> addStudentView();
                    case 2 -> showAllStudentsView();
                    case 3 -> showStudentByStudentNumber();
                    case 4 -> updateStudentview();
                    case 5 -> deleteStudentView();
                    case 6 -> {
                        // switch - case 문의 화살표 문법에서 여러줄의 코드 작성시 {} 로 범위를 감싸야함
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 입력해주세요 ");
                }

            } catch (NumberFormatException e ) {
                System.out.println("숫자를 입력해야합니다." + e.getMessage());
            } catch (Exception e) {
                System.out.println("오류가 발생하였습니다." + e.getMessage());
            }


        }
    }

    private void addStudentView() {
        System.out.println("이름: ");
        String name = sc.nextLine();
        System.out.println("나이: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("학번: ");
        String studentNumber = sc.nextLine();

        StudentRequestDto dto = new StudentRequestDto(name, age, studentNumber);
        controller.addStudent(dto);
    }

    private void showAllStudentsView() {
        List<StudentResponseDto> list = controller.getAllStudents();

        if(list.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
        } else {
            for(StudentResponseDto dto : list) {
                System.out.println(dto);
            }
        }
    }

    private void showStudentByStudentNumber() {
        System.out.println("조회할 학생의 학번: ");
        String studentNumber = sc.nextLine();

        StudentResponseDto dto = controller.getStudentById(studentNumber);
        if(dto == null) {
            System.out.println("해당 학번의 학생이 없습니다." + studentNumber);
        } else {
            System.out.println(dto);
        }
    }

    private void updateStudentview() {
        System.out.print("수정할 학생의 학번 입력: ");
        String studentNumber = sc.nextLine();
        System.out.println("새 이름: ");
        String name = sc.nextLine();
        System.out.println("새 나이:");
        int age = Integer.parseInt(sc.nextLine());

        StudentRequestDto dto = new StudentRequestDto(name, age, studentNumber );

        boolean result = controller.updateStudent(dto);

        System.out.println(result ? "수정완료!!" : "해당학번의 학생을 찾을 수 없습니다.");

    }


    private void deleteStudentView() {
        System.out.println("삭제할 학생의 학번: ");
        String studentNumber = sc.nextLine();
        boolean result = controller.removeStudent(studentNumber);
        System.out.println(result ? "삭제완료!!" : "해당학번의 학생을 찾을 수 없습니다.");
    }
}
