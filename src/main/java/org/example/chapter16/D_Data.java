package org.example.chapter16;

/*
    == DTO, VO, DAT, Entity ==
    : 데이터를 목적에 따라 정의하는 구조

    1) DTO(Data Transfer Object) : 데이터를 전달하기 위한 객체
    2) VO(Value Object) : 값 자체를 표현하는 객체
    3) DAO(Data Access Object) : DB 에 접근하는 역할을 하는 객체
    4) Entity: 실제 DB 테이블과 매핑되는 클래스
 */

// 1) DTO
// : 계층 간 데이터 교환을 위해 사용하는 객체
// - 로직을 가지지 않는 순수한 데이터 객체 (비즈니스 로직X, Getter, Setter 만 존재)
// - 요청과 응답 객체로 구분하여 사용
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class UserSignInRequestDto {
    // 로그인을 위한 요청 값
    private String userId;
    private String password;
}

// 2) VO
// : 특정 값을 표현하는 객체
// - 주로 사용자 주소, 이름, 좌표 등 도메인에서 의미있는 값을 표현
// - 불변성을 가짐 (읽기 전용) : 생성시 내용 변경 불가하도록
// >> 주로 필드값 final, Getter 만을 가짐
@AllArgsConstructor
@Getter
@EqualsAndHashCode
class Address {
    // 데이터 식별값 (id 같은것들)이 필요없음.
    // 동일성 보다 동등성이 중요 (VO 는 값이(객체의 주소값말고 그자체의 내용) 같으면 동일하다고 봄)
    private final String city;
    private final String zipcode;
}

// 3) DAO
// : 데이터베이스 접근 객체
// - 서비스 모델과 데이터 베이스를 연결하는 역할
// - DB에 접근해 CRUD 작업을 담당
// >> 일반적으로 JDBC 또는 JPA, MyBatis 를 통해 구현됨
// >> Spring 기반 프로젝트에서 Repository 또는 Mapper(MyBatis 의 경우) 로 대체됨

// JDBC 기반 (Java + Database)
@AllArgsConstructor
class UserResponseDto {
    String id;
    String nickname;
}

// 실질적인 로직은 DAO 대신 JPA - Repository interface 를 사용
class UserDao {
    // 로그인시 userId 로 사용자 정보 조회
    public UserResponseDto getUserById(String userId) {
        // DB 에 접근해 해당 userId 사용자의 닉네임을 조회했다고 가정
        String id = "qwe";
        String nickname = "개구리";

        return new UserResponseDto(id, nickname);
    }
}

// 4) Entity
// : 실제 DB 테이블에 해당하는 데이터 구조와 매핑되는 클래스
// - JPA (Java Persistence API) 와 같은 ORM(object-Related-Mapping) 툴에서 사용됨
// - DB 의 각 레코드와 매핑됨
// > @Entity, @Id, @Column 등을 사용
@Getter
@Setter
//@Entity - entity 클래스임을 명시
//@Table(name = "users") - DB 의 users 테이블과 연결됨을 명시
class User {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private Date createdAt;
}

public class D_Data {
    public static void main(String[] args) {

    }
}
