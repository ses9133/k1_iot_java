package org.example.chapter15.b_signup;

// 사용자 회원가입 요청 DTO

// cf) DTO
// - 프로세스(계층) 간에 데이터를 전달하는 객체를 의미

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSignUpRequestDto {
    private String username; // 사용자 로그인 아이디
    private String password;
    private String passwordCheck; // 비밀번호 확인용도
    private String name;    // 사용자 진짜 이름
    private String email;
    private String phone;
    private String nickname;
}
