package org.example.chapter15.c_board_app.service;

import org.example.chapter15.c_board_app.entity.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.entity.dto.BoardResponseDto;

import java.util.List;

public interface BoardService {
    // 생성) 요청:BoardRequestDto, 응답: X
    void createBoard(BoardRequestDto dto);

    // 조회) 전체. 요청: X, 응답: List<BoardResponseDto>
    List<BoardResponseDto> findAllBoards();

    // 조회) 단건, 요청 : id, 응답 BoardResponseDto
    BoardResponseDto findBoardById(Long id);

    // 수정) 요청: id, BoardRequestDto, 응답: x
    void updateBoard(Long id, BoardRequestDto dto);

    // 삭제) 요청: id, 응답: x
    void deleteBoard(Long id);

}
