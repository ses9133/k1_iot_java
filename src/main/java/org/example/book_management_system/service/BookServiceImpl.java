package org.example.book_management_system.service;

import org.example.book_management_system.exception.BookNotFoundException;
import org.example.book_management_system.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final List<Book> bookList = new ArrayList<>();

    @Override
    public void add(Book book) {
        bookList.add(book);
        System.out.println("책이 추가되었습니다.");
     }

    @Override
    public List<Book> getAllBooks() {
       return new ArrayList<>(bookList);
    }

    @Override
    public Book searchById(String id) {
        for(Book book : bookList) {
            if(book.getId().equals(id)) {
                return book;
            }
        }
        throw new BookNotFoundException("해당 도서를 찾을 수 없습니다.");
    }

    @Override
    public void updateBookAuthor(String id, String newAuthor) {
        Book book = searchById(id);

        if(book == null) {
            throw new BookNotFoundException("해당 도서를 찾을 수 없습니다.");
        }
        book.setAuthor(newAuthor);
        System.out.println("저자명이 수정되었습니다." + newAuthor);

    }

    @Override
    public void deleteBook(String id) {
        Book bookToDelete = null;

        for(Book book : bookList) {
            if(book.getId().equals(id)) {
                bookToDelete = book;
                System.out.println(id +"번의 책이 정상적으로 삭제되었습니다.");
                break;
            }
        }
        if(bookToDelete == null) {
            throw new BookNotFoundException("해당 도서를 찾을 수 없습니다.");
        }

        bookList.remove(bookToDelete);
    }

    @Override
    public List<Book> searchByTitle(String title) {
        List<Book> searchBook = new ArrayList<>();

       for(Book book : bookList) {
           if(book.getTitle().contains(title)) {
               searchBook.add(book);
           }
       }
        if (searchBook.isEmpty()) {
            throw new BookNotFoundException("해당 도서를 찾을 수 없습니다.");
        }

       return searchBook;

    }
}
