package org.example.book_management_system;


import org.example.book_management_system.exception.BookNotFoundException;
import org.example.book_management_system.model.Book;
import org.example.book_management_system.service.BookService;
import org.example.book_management_system.service.BookServiceImpl;

import java.util.List;

public class C_Main {
    public static void main(String[] args) {
        //전체 흐름(추가 → 수정 → 조회 → 삭제 → 검색)을 테스트했는가?

        System.out.println("==== 추가 =====");
        // 추가
        BookService bookService = new BookServiceImpl();
        bookService.add(new Book("1", "책1", "정은혜"));
        bookService.add(new Book("2", "책2", "홍길동"));
        bookService.add(new Book("3", "책3", "홍길남"));

        System.out.println("==== 전체 조회 =====");
        // 전체 조회
        List<Book> books = bookService.getAllBooks();
        for(Book book: books) {
            System.out.println(book);
        }

        System.out.println("==== 수정 =====");
        // 수정
        try {
            bookService.updateBookAuthor("1", "정세이");
            bookService.updateBookAuthor("100", "정세이");
        } catch (BookNotFoundException e) {
            System.out.println("수정 실패:" + e.getMessage());
        }

        System.out.println("==== 삭제 =====");
        // 삭제
        try {
            bookService.deleteBook("2");
            bookService.searchById("2");
        } catch (BookNotFoundException e) {
            System.out.println("삭제 실패:" + e.getMessage());
        }


        System.out.println("==== 책제목으로 검색====");
        // 검색
//        try {
//            Book book1 = bookService.searchByTitle("책1");
//            System.out.println(book1);
//            Book book2 = bookService.searchByTitle("책2");
//            System.out.println(book2);
//        } catch (BookNotFoundException e) {
//            System.out.println("검색 실패: " + e.getMessage());
//        }

        System.out.println("==== 아이디로 검색====");
        // 검색
        try {
            Book book3 = bookService.searchById("3");
            System.out.println(book3);
            Book book100 = bookService.searchById("100");
            System.out.println(book100);
        } catch (BookNotFoundException e) {
            System.out.println("검색 실패: " + e.getMessage());
        }






    }
}
