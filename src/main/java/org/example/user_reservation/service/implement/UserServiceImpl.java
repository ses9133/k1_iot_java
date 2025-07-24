package org.example.user_reservation.service.implement;

import org.example.user_reservation.dto.UserLoginRequestDto;
import org.example.user_reservation.dto.UserRegisterRequestDto;
import org.example.user_reservation.entity.User;
import org.example.user_reservation.repository.UserRepository;
import org.example.user_reservation.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private User loggedUser; // 로그인된 사용자 정보를 저장하는 필드

    public UserServiceImpl() {
        this.userRepository = new UserRepository();
    }

    @Override
    public void registerUser(UserRegisterRequestDto dto) {
        // dto 내부의 userId 값을 사용하여 기존의 데이터와 비교ㅕ
        Optional<User> optionalUser = userRepository.findByUserId(dto.getUserId());

        // cf) 옵셔녈데이터.get() : Optional 내부의 데이터를 반환, 데이터가 없을 경우 null 반환
        // - 값이 존재하지 않을 때 NoSuchElementException 예외 발생
        Optional<String> optional = Optional.empty();
        // optional.get(); // -> NoSuchElementException

        // isPresent(), isEmpty()

        if(optionalUser.isPresent()) {
            // 해당 아이디의 유저가 존재 - 회원가입 불가
            System.out.println("해당 ID 의 유저가 이미 존재합니다. 다시 시도해주세요");
            return;
        }
        // 회원가입 정상 로직 실행
        String password = dto.getPassword();
        String passwordCheck = dto.getPasswordCheck();

        if(!password.equals(passwordCheck)) {
            // 비밀번호와 비밀번호 확인이 일치하지 않는 경우 -회원가입 불가능
            System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다. 다시 시도해주세요");
            return;
        }

        User newUser = new User(dto.getUserId(), password, dto.getName(), dto.getEmail());
        userRepository.save(newUser);
        System.out.println("사용자 회원 가입 완료: " + dto.getName());
    }

    @Override
    public void login(UserLoginRequestDto dto) {
        String userId = dto.getUserId();
        String password = dto.getPassword();

        // ifPresentOrElse(a, b);
        // : 정보가 존재하는 a 로직 실행, 존재하지 않을 경우 b 로직 실행
        userRepository.findByUserId(userId).ifPresentOrElse(user -> {
            // 데이터가 있는 경우
            // user 값 내부의 password 값과 dto 요청 값 내부의 password 의 일치 여부 확인
            if(user.getPassword().equals(password)) {
                loggedUser = user; // 로그인 정보 저장
                System.out.println("로그인 성공: " + user.getName());
            } else {
                System.out.println("로그인 실패: 비밀번호가 일치하지 않습니다.");
            }
        }, () -> System.out.println("로그인 실패: 사용자 ID를 찾을 수 없습니다."));
    }

    @Override
    public void logout() {
        if(loggedUser != null) { // 로그인 중
            System.out.println("로그아웃 성공 : " + loggedUser.getName());
            loggedUser = null;
        } else {
            System.out.println("로그인 상태가 아닙니다. 로그아웃 할 수가 없습니다.");
        }
    }

    @Override
    public boolean isLoggedIn() {
        boolean result = loggedUser != null; // loggedUser == null 이면 false
        // 로그인 중이면 true 반환, 로그인 상태 아니면 false 반환
        return result;
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
