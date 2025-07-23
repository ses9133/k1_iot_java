package org.example.chapter15.c_board_app.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.chapter15.c_board_app.entity.Board;

// 사용자에게 요청 받은 데이터를 정의
// - id 를 제외한 필드 제공
@AllArgsConstructor
@Getter
public class BoardRequestDto {
    private String title;
    private String content;
    private String author;

    public Board toEntity() {
        // 요청값으로 Board 객체 생성
        return new Board(title, content, author);
    }

 }
