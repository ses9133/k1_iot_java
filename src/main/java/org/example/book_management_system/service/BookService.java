package org.example.book_management_system.service;

import org.example.book_management_system.model.Book;

import java.util.List;

public interface BookService {
    void add(Book book);
    List<Book> getAllBooks();
    Book searchById(String id);
    void updateBookAuthor(String id, String newAuthor);
    void deleteBook(String id);
    List<Book> searchByTitle(String title);
}
