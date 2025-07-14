package org.example.chapter12.view;

import org.example.chapter12.controlelr.StudentController;

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

    }

    private void addStudentView() {

    }

    private void showAllStudentsView() {

    }

    private void updateStudentView() {

    }

    private void deleteStudentView() {

    }
}
