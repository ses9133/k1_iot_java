package org.example.chapter12.view;

import org.example.chapter12.controlelr.BookController;
import org.example.chapter12.model.Book;

import java.util.List;
import java.util.Scanner;

public class BookView {

    private final BookController controller;
    private final Scanner sc;

    public BookView(BookController controller, Scanner sc) {
        this.controller = controller;
        this.sc = sc;
    }

    public void showMenu() {

        while(true) {
            System.out.println("1. Add new Book: ");
            System.out.println("2. Show All Book List: ");
            System.out.println("3. search Title: ");
            System.out.println("4. quit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addBookView();
                    break;
                case 2:
                    showAllBooks();
                    break;
                case 3:
                    searchBookTitle();
                    break;
                case 4:
                    System.out.println("종료합니다.");
                    return;
                default:
                    System.out.println("올바른 입력값을 입력하세요");
                    break;
            }
        }
    }

    private void addBookView() {
        System.out.println("Book Title: ");
        String title = sc.nextLine();
        System.out.println("Book author");
        String author = sc.nextLine();
        System.out.println("Book publisher");
        String publisher = sc.nextLine();

        controller.addBook(title, author, publisher);
    }

    private void showAllBooks() {
        List<Book> books = controller.getAllBooks();
        for(Book book : books) {
            System.out.println(book);
        }
    }

    private void searchBookTitle() {
        System.out.println("책 제목을 검색하세요: ");
        String title = sc.nextLine();

        List<Book> foundBooks = controller.searchBookByTitle(title);

        for(Book book : foundBooks) {
            System.out.println(book);
        }
    }


}
