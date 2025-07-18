package org.example.chapter09_practice;
/*
    === 사용자(user) 관리 시스템 구현 ==
    : 사용자 정보를 관리하는 시스템
    - 사용자 생성 및 수정 등을 처리
    - 생성 및 수정 시 생성일, 수정일을 기록 - DateUtil 사용

    1) 요구 사항
    User 클래스
    - 필드: id(사용자 고유 번호), name, email, createdAt, updatedAt
    - 생성자: createdAt 값을 설정 (+ 정보 수정시 updatedAt 설정)
    - 메서드: toString() 오버라이딩하여 사용자 정보 출력

    DateUtil 유틸 클래스
    - 메서드: 현재 날짜 및 시간을 yyyy-MM-dd HH:mm:ss 형식으로 반환 (getCurrentDateTime())

    UserService 인터페이스
    - 사용자 추가, 조회(단건, 전체), 수정

    UserServiceImpl 클래스
    - ArrayList<User> 을 사용하여 사용자 목록 관리
    - 존재하지 않는 id 로 조회, 수정하는 경우 사용자 정의 예외 발생

    UserNotFoundException 예외 클래스
    - 메시지를 받아 출력하는 사용자 정의 예외

    Main 클래스: 프로그램 실행의 진입점
    - UserServiceImpl 를 인스턴스화 하여 동작을 실행
 */

// model
// : 정보(데이터)를 담는 틀
// ex) 학생 정보를 저장
//      Student 라는 클래스 모델이 있고,
//      해당 모델 내에 이름, 나이, 학번 등이 저장됨

import org.example.chapter09_practice.exception.UserNotFoundException;
import org.example.chapter09_practice.model.User;
import org.example.chapter09_practice.service.UserService;
import org.example.chapter09_practice.service.UserServiceImpl;

import java.util.List;

// service
// : 일을 처리하는 곳
// ex) 학생 등록하기, 학생 정보 가져오기, 학생 삭제하기 등을 처리
//      >> model 을 가지고 일을 하는 곳
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // 1. 사용자 추가
        userService.addUser(new User(1, "정은혜", "qwe123@naver.com"));
        userService.addUser(new User(2, "홍길동", "zxcv456@naver.com"));
        userService.addUser(new User(3, "홍길남", "iop789@naver.com"));
        userService.addUser(new User(4, "이승아", "asdfadsf@naver.com"));
        userService.addUser(new User(5, "이승아", "123454@naver.com"));

        // 2. 전체 조회
        List<User> users = userService.getAllUsers();
        for(User user: users) {
            System.out.println(user);
        }

        // 이메일 수정
        try {
            userService.updateUserEmail(1, "ses9133@naver.com");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 단건 회원 조회
        User user = userService.getUserById(1);
        System.out.println(user);

        // 존재하지 않는 사용자 검색
        try {
            userService.updateUserEmail(6, "ses9133@naver.com");
        } catch (UserNotFoundException e) {
            System.out.println("조회실패: " + e.getMessage());
        }

        // 사용자 삭제
        try {
            userService.deleteUser(1);
            System.out.println("사용자가 정상적으로 삭제되었습니다.");

            User result = userService.getUserById(1);
            System.out.println(result);

            userService.deleteUser(100);
        } catch (UserNotFoundException e) {
            System.out.println("삭제실패:" + e.getMessage());
        }

        // 특정이름 조회(필터링)
        String searchName = "이승아";
        List<User> filteredUsers = userService.findUsersByName(searchName);
        System.out.println("\n[" + searchName + "] 이름으로 조회된 사용자 목록: " );

        for(User userData : filteredUsers) {
            System.out.println(userData);
        }

    }
}
