package org.example.chapter09_practice.service;

import org.example.chapter09_practice.exception.UserNotFoundException;
import org.example.chapter09_practice.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    // 사용자 배열 생성
    private final List<User> userList = new ArrayList<>();

    // cf) CRUD
    // : 개발에서 데이터(model) 처리의 기본적인 4가지 기능
    // : C(Create): 데이터 생성(ex. 회원가입)
    // : R(Read): 데이터 조회(ex. 게시글 목록보기)
    // : U(Update): 데이터 수정(ex. 내 정보 수정)
    // : D(Delete): 데이터 삭제(ex. 게시글 삭제)

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        // return userList; -> 하지 않는 이유: 방어적 복사
        // cf) 방어적 복사
        // : 객체(배열, 클래스 타입)의 내부 상태를 외부에 노출하지 않고 보호하기 위한 프로그래밍 기법
        // - 원본 ArrayList 객체의 요소를 복사하여 새로운 리스트(주소값)를 생성
         return new ArrayList<>(userList);
    }

    @Override
    public User getUserById(int id) {
        // 사용자 리스트를 순회하여 해당 id 와 일치하는 사용자가 있는 경우, 반환
        // +) 해당 id의 사용자가 없는 경우 UserNotFoundException 발생
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException("사용자 ID 에 " + id + " 값이 없습니다. (조회실패)");
    }

    @Override
    public void updateUserEmail(int id, String newEmail) {
        // 사용자 특정 id 값으로 사용자 정보 반환 또는 예외 발생
        User user = getUserById(id);
        user.setEmail(newEmail);
    }

    @Override
    public List<User> findUsersByName(String name) {
        // 반환값을 담을 변수 선언 & 초기화
        List<User> result = new ArrayList<>();

        for(User user : userList) {
            if(user.getName().equals(name)) {
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public void deleteUser(int id) {
        // list.remove(제거할요소); 이때 제거요소타입은 리스트 요소타입과 일치해야함

        User userToDelete = null; // 전체 리스트에서 특정 id 와 일치하는 사용자 정보를 담을 변수 선언

        for(User user : userList) {
            if(user.getId() == id) {
                userToDelete = user;
                break;  // break; 는 반복문의 종료. (return 처럼 메서드 종료가 아님)
            }
        }

        if(userToDelete == null) {
            throw new UserNotFoundException("사용자 ID 에 " + id + " 값이 없습니다.(삭제 실패)" );
        }

        // 삭제
        userList.remove(userToDelete);
        // List<User> 에서 userToDelete(User 타입) 을 제거한다.

    }
}
