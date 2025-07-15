package org.example.chapter12.controller;

import org.example.chapter12.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    private List<Book> bookList;

    public BookController(List<Book> bookList) {
        this.bookList = bookList;
    }

    // 1. 책추가
    public void addBook(String title, String author, String publisher) {
        Book newBook = new Book(title, author, publisher);
        bookList.add(newBook);
    }

    // 2. 모든 도서 정보 출력
    public List<Book> getAllBooks() {
        return bookList;
    }

    // 3. 도서 검색(by 제목)
    public List<Book> searchBookByTitle(String keword) throws NullPointerException {
        List<Book> books = new ArrayList<>();

        try {
            for (Book book : bookList) {
                if (book.getTitle().contains(keword)) {
                    books.add(book);
                }
            }
            if(books.isEmpty() || books == null) throw new NullPointerException("찾는 책이 없습니다.");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return books;
    }
}
