package org.example.chapter15.b_signup;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

// 실제 회원 가입 프로세스의 사용자 데이터
@Getter
@Builder
public class User {
    private Long id; // 보통 데이터 저장소에서 일괄 부여됨
    private String username; // 사용자 로그인 아이디
    private String password;
    private String name;    // 사용자 진짜 이름
    private String email;
    private String phone;
    private String nickname;
    private Date signUpDate;
}
