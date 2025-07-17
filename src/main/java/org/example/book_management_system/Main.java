package org.example.book_management_system;

import org.example.book_management_system.exception.BookNotFoundException;
import org.example.book_management_system.model.Book;
import org.example.book_management_system.service.BookService;
import org.example.book_management_system.service.BookServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BookService bookService = new BookServiceImpl();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("=== 도서 관리 시스템 ===");
            System.out.println("1. 책 추가");
            System.out.println("2. 책 삭제");
            System.out.println("3. 책 전체 조회");
            System.out.println("4. 제목으로 책 조회");
            System.out.println("5. 번호로 책 조회");
            System.out.println("6. 책 저자 수정");
            System.out.println("7. 프로그램 종료");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: {
                        System.out.println("번호: ");
                        String id = sc.nextLine();
                        System.out.println("제목: ");
                        String title = sc.nextLine();
                        System.out.println("이름: ");
                        String author = sc.nextLine();
                        bookService.add(new Book(id, title, author));
                        break;
                    }
                    case 2: {
                        System.out.println("삭제할 책의 번호를 입력하세요");
                        String id = sc.nextLine();
                        bookService.deleteBook(id);
                        break;
                    }
                    case 3:
                        System.out.println(bookService.getAllBooks());
                        break;
                    case 4: {
                        System.out.println("제목을 입력하세요");
                        String title = sc.nextLine();
                        System.out.println(bookService.searchByTitle(title));
                        break;
                    }
                    case 5: {
                        System.out.println("책 번호를 입력하세요");
                        String id = sc.nextLine();
                        System.out.println(bookService.searchById(id));
                        break;
                    }
                    case 6: {
                        System.out.println("수정할 책의 번호를 입력하세요");
                        String id = sc.nextLine();
                        System.out.println("바꿀 저자의 이름을 입력하세요");
                        String author = sc.nextLine();
                        bookService.updateBookAuthor(id, author);
                        break;
                    }
                    case 7: {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default:
                        System.out.println("올바른 값을 입력해주세요");
                        break;
                }

            } catch (BookNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }



}
