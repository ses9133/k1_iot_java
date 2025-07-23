package org.example.chapter15.c_board_app.view;

import org.example.chapter15.c_board_app.controller.BoardController;
import org.example.chapter15.c_board_app.entity.Board;
import org.example.chapter15.c_board_app.entity.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.entity.dto.BoardResponseDto;

import java.util.List;
import java.util.Scanner;

/*
    === 게시글 관리 시스템 ===

    Board 게시판
    : CRUD

 */
public class BoardView {
    public static void main(String[] args) {
        BoardController boardController = new BoardController();
        Scanner sc = new Scanner(System.in);

        while(true) {

            try {
                System.out.println("\n[ 게시판 관리 시스템 ]");
                System.out.println("1. 게시글 등록");
                System.out.println("2. 게시글 전체 조회(게시글 목록)");
                System.out.println("3. 게시글 단건 조회(게시글 상세 페이지)");
                System.out.println("4. 게시글 수정");
                System.out.println("5. 게시글 삭제");
                System.out.println("0. 프로그램 종료");

                System.out.print("메뉴를 선택해주세요 >>");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: {
                        System.out.println("게시글 등록(제목, 내용, 작성자를 입력해주세요)");
                        System.out.print("제목: ");
                        String title = sc.nextLine();
                        System.out.print("내용: ");
                        String content = sc.nextLine();
                        System.out.print("작성자: ");
                        String author = sc.nextLine();

                        boardController.createdBoard(new BoardRequestDto(title, content, author));
                        break;
                    }
                    case 2: {
                        System.out.println("게시글 전체 조회");
                        List<BoardResponseDto> dtos = boardController.getAllBoards();
                        dtos.forEach(System.out::println);
                        break;
                    }
                    case 3: {
                        System.out.println("게시글 단건 조회");
                        System.out.println("조회할 게시글 id: ");
                        Long id = sc.nextLong();
                        sc.nextLine();

                        BoardResponseDto dto = boardController.getBoardById(id);
                        System.out.println(dto);
                        break;
                    }
                    case 4: {
                        System.out.println("게시글 수정(수정할 게시글의 id 와 새로운 제목과 내용을 입력해주세요ㅕ)");
                        System.out.print("수정할 게시글 id: ");
                        Long updatedId = sc.nextLong();
                        sc.nextLine();
                        System.out.print("새 제목: ");
                        String title = sc.nextLine();
                        System.out.print("새 내용: ");
                        String content = sc.nextLine();

                        BoardRequestDto dto = new BoardRequestDto(title, content, "수정은 작성자 X");
                        // 원래라면 dto 를 생성용, 수정용 등 따로 만듦

                        boardController.updateBoard(updatedId, dto);
                        break;

                    }
                    case 5: {
                        System.out.println("게시글 삭제");
                        System.out.println("삭제할 게시글 id: ");
                        Long id = sc.nextLong();
                        sc.nextLine();
                        boardController.deleteBoard(id);
                        break;
                    }
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        sc.close();
                        return;
                    default:
                        System.out.println("잘못된 선택입니다. 0~5 사이 값을 입력해주세요");
                        break;

                }

            } catch (IllegalArgumentException e) {
                // 인수값으로 부적절한 값을 넘길 때 발생하는 예외
                System.out.println("id 값을 확인해주세요: " + e.getMessage());
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
