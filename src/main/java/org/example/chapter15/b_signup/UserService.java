package org.example.chapter15.b_signup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {
    public static User signUp(UserSignUpRequestDto dto) {
        User user = null;

        try {
            // 회원 데이터 유효성 검증
            // : 비밀번호와 비밀번호 확인 값의 일치 유무 검증
            String password = dto.getPassword();
            String passwordCheck = dto.getPasswordCheck();

            if(!password.equals(passwordCheck)) {
                throw new Exception("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            }

            Long id = 1L; // DB 역할을 대신
            Date nowDate = new Date(); // 회원가입 시점을 저장

            user = User.builder()
                    .id(id)
                    .username(dto.getUsername())
                    .password(password)
                    .name(dto.getName())
                    .email(dto.getEmail())
                    .phone(dto.getPhone())
                    .nickname((dto.getNickname()))
                    .signUpDate(nowDate)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    public static void main(String[] args) {
        // 1) 사용자로부터 요청값을 받음 (serSignUpRequestDto 형식)
        // 2) 요청값 검증
        // 3) User 형식으로 데이터 저장
        // 4) User 타입으로 반환

        UserSignUpRequestDto dto1 = new UserSignUpRequestDto(
                "qwe123", "qwe123123", "qwe123123",
                "이승아", "qwe123@naver.com", "010-111-122", "이승아"
        );

        User user1 = signUp(dto1);
        System.out.println(user1.getSignUpDate());

        UserSignUpRequestDto dto2 = new UserSignUpRequestDto(
                "ses9133", "a123123", "a123123",
                "이승아2", "ses9133@naver.com", "010-111-122", "이승아"
        );

        User user3 = signUp(dto2);
        System.out.println(user1.getSignUpDate());

        List<User> userList = null;
        List<UserSignUpRequestDto> dtos = new ArrayList<>();
        dtos.add(dto1);
        dtos.add(dto2);

        userList = dtos.stream()
               // .map(dto -> signUp(dto))
                .map(UserService::signUp)
                .toList();

        userList.forEach(System.out::println);

    }
}
