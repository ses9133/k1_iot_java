package org.example.chapter12.view;


import org.example.chapter12.controlelr.BookController;
import org.example.chapter12.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * === 도서 관리 시스템 ===
 * *
 * * 1. 요구 사항 분석
 * *   - 새로운 도서 추가: addBook
 * *   - 모든 도서 정보 출력: getAllBooks
 * *   - 도서 검색 (도서 제목으로 검색): searchBookByTitle
 * *
 * * 2. 프로그램 구조
 * *
 * * Model(도서 정보 담당)
 * *   - Book 클래스: 도서 정보 저장(제목, 저자, 출판사 등)
 * *
 * * View(사용자 인터페이스 UI를 담당)
 * *   - BookView 클래스: 사용자의 입력을 받아 Controller에게 전달 & Controller에게 받은 정보를 출력
 * *
 * * Controller(사용자의 입력을 처리 - Model과 View 사이를 중재)
 * *   - BookController 클래스: 사용자의 입력에 따라 적절한 Model 메서드를 호출
 *
 * */
public class LibraryManagement {
    public static void main(String[] args) {

        List<Book> dummy = new ArrayList<>();
        dummy.add(new Book("wkqqkk", "정은혜", "abc"));
        dummy.add(new Book("java", "jeh", "cdf"));

        BookController bookController = new BookController(dummy);
        Scanner sc = new Scanner(System.in);

        BookView bookView = new BookView(bookController, sc);
        bookView.showMenu();



    }
}
