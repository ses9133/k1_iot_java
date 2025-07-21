package org.example.chapter13.practice.service;

import org.example.chapter13.practice.model.Book;
import org.example.chapter13.practice.repository.BookRepository;

import java.util.List;

// 비즈니스 로직 처리 - 싱글톤 패턴 적용
public class BookSerivceImpl implements BookManager<Book> {

    // 싱글톤 필드 - private static
    private static BookSerivceImpl instance;

    private final BookRepository repository = BookRepository.getInstance();

    // 싱글톤 생성자 private
    private BookSerivceImpl() {

    }

    // 싱글톤 인스턴스화 메서드 public static
    public static BookSerivceImpl getInstance() {
        if(instance == null) {
            instance = new BookSerivceImpl();
        }
        return instance;
    }

    @Override
    public void addBook(Book book) {
        Book addedBook = repository.save(book); // 저장완료시 Book 데이터 반환, 실패시 null 반환

        if(addedBook == null) {
            System.out.println("해당 ID의 도서가 이미 존재하여 책이 추가되지 않았습니다.");
        } else {
            System.out.println(book.getTitle() + " (이)가 추가(또는 수정) 되었습니다.");
        }
    }

    @Override
    public Book findBookById(String id) {
        Book book = repository.findById(id);
        if(book == null) {
            System.out.println("ID [" + id + " ] 에 해당하는 도서를 찾을 수 없습니다." );
        }
        return book;
    }

    @Override
    public List<Book> listAllBooks() {
        return repository.findAll();
    }

    @Override
    public void updateBook(String id, Book updatedBook) {
        // 수정: id 와 일치하는 기존의 데이터를 삭제 + 신규(수정된) 데이터 저장 하는 형식으로
        Book existingBook = repository.findById(id);

        if(existingBook == null) {
            System.out.println("ID [" + id + " ] 에 해당하는 도서를 찾을 수 없습니다." );
            return;
        }
        // 존재하면
        repository.delete(id);
        addBook(updatedBook);
    }

    @Override
    public void deleteBook(String id) {
        Book existingBook = repository.findById(id);

        if(existingBook == null) {
            System.out.println("ID [" + id + " ] 에 해당하는 도서를 찾을 수 없습니다." );
            return;
        }
        // 존재하면
        repository.delete(id);
        System.out.println(existingBook.getTitle() + " (이)가 삭제되었습니다.");

    }
}
