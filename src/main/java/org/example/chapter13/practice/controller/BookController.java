package org.example.chapter13.practice.controller;

import org.example.chapter13.practice.model.Book;
import org.example.chapter13.practice.service.BookSerivceImpl;
import org.example.chapter13.practice.view.BookView;

import java.util.List;

// 사용자의 요청을 처리
public class BookController {
    // 싱글톤 패턴 인스턴스화
    private final BookSerivceImpl service = BookSerivceImpl.getInstance();
    // 뷰 인스턴스화
    private final BookView view = new BookView();

    public void start() {
        while(true) {
            view.showMenu();
            int choice = view.getInputMenuNumber();

            switch (choice) {
                case 1: // 책추가 : 요청 O, 반환 X
                    Book book = view.getBookDetails();
                    if(book != null) service.addBook(book);
                    else System.out.println("필수 데이터값을 다시 확인해주세요");
                   break;
                case 2:// 단건조회 : 요청 O, 반환 O
                    String findBookId = view.getInputString("ID");
                    if(findBookId != null) {
                        Book foundBook = service.findBookById(findBookId);
                        view.displayBook(foundBook);
                    }
                    break;
                case 3: // 전체 조회: 요청 X, 반환 O
                    List<Book> books = service.listAllBooks();
                    view.displayBooks(books);
                    break;
                case 4: // 도서 수정
                    String updateId = view.getInputString("ID");
                    if(updateId != null) {
                        Book updatedBook = view.getBookDetails();
                        if(updatedBook != null) {
                            service.updateBook(updateId, updatedBook);
                        } else {
                            System.out.println("수정할 도서 정보가 유효하지 않습니다.");
                        }
                    }
                    break;
                case 5:  // 도서 삭제
                    String removeId = view.getInputString("ID");
                    if(removeId != null) {
                        service.deleteBook(removeId);
                    } else {
                        System.out.println("삭제할 책이 없습니다.");
                    }
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 메뉴 번호를 다시 입력해주세요");
            }
        }
    }
}
