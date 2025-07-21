package org.example.chapter13.practice.repository;

import org.example.chapter13.practice.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 도서를 저장, 검색 및 삭제하는 데이터 저장소
public class BookRepository {
    // 단일 저장소를 위한 싱글톤 인스턴스 생성
    private static final BookRepository instance = new BookRepository();

    // 도서 저장소 만들기 (id 값을 key 로 저장하는 Map 사용)
    private Map<String, Book> bookStore = new HashMap<>();

    // 싱글톤 생성자 private
    private BookRepository() {

    }

    // 싱글톤 인스턴스 반환 메서드 "public static"
    public static BookRepository getInstance() {
        return instance;
    }

    // 도서 저장(Create)
   public Book save(Book book) {
        // 중복된 id 값일 경우 도서 저장 X
       if(bookStore.containsKey(book.getId())) {
           System.out.println("[" + book.getId() + "] 의 책이 이미 존재합니다. 다시 입력해주세요");
           return null;
       }

       bookStore.put(book.getId(), book);
       return book;

   }

    // 도서 조회(Read - 단건)
    public Book findById(String id) {
        return bookStore.get(id);
    }
    /*
       책 저장소를 Map 이 아닌 List 로 썼다면,
       책 저장소 전체를 순회하여 매개변수의 id 값과 일치하는 요소를 필터링하여 반환
     */

    // 도서 조회(Read - 전체)
    public List<Book> findAll() {
        return new ArrayList<>(bookStore.values()); // value 를 Collection 형식으로
    }

    // 도서 삭제
    public boolean delete(String id) {
        if(!bookStore.containsKey(id)) {
            // 삭제하고자 하는 id 의 책이 없는 경우
            System.out.println("[" + id + "] 의 책이 존재하지 않습니다. 책이 삭제되지 않았습니다.");
            return false;
        }
        bookStore.remove(id);
        return true;
    }

}
