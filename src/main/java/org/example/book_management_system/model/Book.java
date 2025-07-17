package org.example.book_management_system.model;

import org.example.book_management_system.util.DateUtil;

public class Book {
    private String id;
    private String title;
    private String author;
    private String createdAt;
    private String updatedAt;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdAt = DateUtil.now();
        this.updatedAt = DateUtil.now();
    }

    public void setAuthor(String author) {
        this.author = author;
        this.updatedAt = DateUtil.now();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "책 정보: " + "id= " + id + " , 책 제목 = " + title + ", 저자= " + author + ", 생성일: " + createdAt + ", 수정일: " + updatedAt;
    }
}
