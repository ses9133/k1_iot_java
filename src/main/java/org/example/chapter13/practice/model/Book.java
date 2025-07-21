package org.example.chapter13.practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public abstract class Book {
    // 추상 클래스: 직접적인 인스턴스화 X, 하위 클래스 생성자 내에서 호출용도로 정의(생서자를 가질 수는 있음)
    private String id;
    private String title;
    private String author;

}
