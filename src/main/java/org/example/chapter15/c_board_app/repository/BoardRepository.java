package org.example.chapter15.c_board_app.repository;

import org.example.chapter15.c_board_app.entity.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardRepository {
    private final List<Board> boardStorage = new ArrayList<>();
    private Long idSequence = 1L;

    public void save(Board board) {
        board.setId(idSequence++);
        boardStorage.add(board);
    }

    public List<Board> findAll() {
        return new ArrayList<>(boardStorage);
    }

    public Optional<Board> findById(Long id) {
        return boardStorage.stream()
                .filter(board -> board.getId() == id)
                .findFirst(); // Stream() 에서 조건에 맞는 첫 번째 요소를 반환 (Optional 타입의 객체로 반환) >> 조건에 맞는 요소가 없는 경우 null 이 담겨서 반환됨
    }

    public void delete(Long id) {
        // removeIf(Predicate);
        boardStorage.removeIf(board -> board.getId() == id);
    }

}
