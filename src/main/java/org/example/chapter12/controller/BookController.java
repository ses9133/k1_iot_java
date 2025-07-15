package org.example.chapter12.controller;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    private List<Book> books;  // 실제 데이터들이 저장되는 리스트
    // private final List<Book> books = new ArrayList<>();  - 1) 필드 주입 방식
    // >> 코드 간결화, 초기값 확인에 용이

    // 2) 생성자 주입 형식
    // >> 유연성 증가: 생성자를 통해 다른 리스트로 주입 가능(Ex. 테스트용 더미 리스트 등)
    // >> 의존성 주입 구조로 변경가능함
    // 단점) 코드 복잡성 증가
    public BookController(List<Book> books) {
        this.books = books;
    }

    // 1. 책 추가 (요청: 책 데이터, 응답: X)
    public void addBook(String title, String author, String publisher){
        Book newBook = new Book(title, author, publisher);
        books.add(newBook);
    }

    // 2. 책 조회 (요청 X, 응답 책데이터 리스트)
    public List<Book> getAllBooks() {
//        List<Book> bookList = new ArrayList<>();
//        for(Book book : bookList) {
//            bookList.add(book);
//        }
        return books;
    }

    // 3. 책 검색(by 제목) (요청: 검색어, 응답: 검색된 책 데이터 리스트)
    public List<Book> searchBook(String title) {
        List<Book> result = new ArrayList<>();

        for(Book book : books) {
            if(book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        if(result.isEmpty()) System.out.println("해당 책이 없습니다.");
        return result;
    }

}
