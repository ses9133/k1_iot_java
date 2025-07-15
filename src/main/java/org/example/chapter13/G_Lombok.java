package org.example.chapter13;

// === 롬복 라이브러리 === //
// : 자바에서 반복적으로 작성해야하는 보일러 플레이트 코드를 줄여주는 라이브러리
// - 어노테이션(코드 주석)을 사용하여 코드를 간결하게 만들어주는 역할

// cf) 대표적인 보일러 플레이트 코드
// 보일러 플레이트 코드
// : 프로그래밍에서 반복되는 작업이나 패턴에 대한 일종의 표준화된 코드
// - Getter/Setter
// - toString
// - 생성자
// - 빌더 패턴 등

// === 라이브러리 VS 프레임워크 === //
// 1) 라이브러리
//  : 개발자가 만들어 낸 클래스들의 나열 (기능 모음)
//  - 원하는 기능을 라이브러리 내에서 추출하여 사용
//  >> 개발자가 라이브러리를 제어 (개발자가 호출한다)
// ex) Lombok, Gson, React,,

// 2) 프레임워크( 틀 + 일하다 )
// : 개발자가 따라야하는 가이드를 제공 (아키텍처 제공)
// >> 프레임워크가 개발자를 제어(프레임 워크가 호출을 함)
// ex) Spring, Django

// === 롬복 환경 설정 === //
// cf) Java + Gradle 빌드도구 사용 프로젝트 일때
// 1) build.gradle 파일에 롬복 추가

// +) Maven Repository
//  : 자바 프로젝트에 필요한 라이브러리(외부 코드) 들을 쉽게 다운로드 하고 관리할 수 있도록 도와주는 저장소
// - 주로 Maven 빌드 도구와 함께 사용되지만, Gradle 에서도 사용

// 2) gradle 리로드(refresh)

// 3) 설정(빌드, 실행, 배포 > 컴파일러 > 어노테이션 처리 활성화)

// === 롬복 어노테이션 종류 === //
// 1. @Getter/@Setter
// : 필드에 대한 getter 와 setter 메서드를 자동 생성

// 2. @ToString
// : 클래스의 toString() 메서드를 자동 구현
// - 객체 출력시 지정된 형식으로 출력
// - 클래스명(필드명1=필드값1, 필드명2=필드값2, ...)

// 3. 생성자 어노테이션
// cf) 매개변수 params, 인자 args

// 1) NoArgsConstructor: 인자가 없는 생성자
// 2) AllArgsConstructor: 모든 필드값을 인자로 받는 생성자
// 3) RequiredConstructor: final 또는 @NonNull 어노테이션이 붙은 필드를 인자로 받는 생성자

// 4. @Data
// @Getter, @Setter, @ToString, @RequiredConstructor, @EqualsAndHashCode 합친거

// 5. @EqualsAndHashCode
// : 두 객체의 내용이 같은지(동등성) 비교 & 두 객체가 같은 객체인지(동일성) 비교 연산자
// > boolean 값 반환

// 6. @Builder
// : 복잡한 객체 생성시 사용하는 빌더 패턴을 자동으로 구현시켜줌
// - 필드값을 모두 메서드 체이닝으로 가져옴 (필수값 또한 메서드 체이닝으로 구성)
// - 메서드 체이닝 이름은 필드명
// >> 필수값을 체이닝에서 누락하면 오류가 남

import lombok.*;

@Data
@Getter
@Setter
@ToString
//@NoArgsConstructor
@AllArgsConstructor // title, author, publisher
@RequiredArgsConstructor    // title, author
@Builder

class Lombok {
    private final String title;

    @NonNull  // null 값이 들어갈 수 없음, 필드에 필수값 지정해야함. (cf. final 과의 차이: final 은 불변성, NonNull 은 변할 수 있음)
    private String author;

    private String publisher;

//    Lombok(String title, String author) {
//        this.title = title;
//        this.author = author;
//    } -> @RequiredArgsConstructor 대체 가능
//
//    Lombok(String title, String author, String publisher) {
//        this.title = title;
//        this.author = author;
//        this.publisher = publisher;
//    } -> @AllArgsConstructor 대체 가능

//    public String getTitle() {
//        return title;
//    }
//    public void setAuthor(String author) {
//        this.author = author;
//    } -> @Getter, @Setter 대체 가능

}

public class G_Lombok {
    public static void main(String[] args) {
        Lombok lombok1 = new Lombok("자바는 재밌어", "이승아", "kore a");
        Lombok lombok2 = new Lombok("자바를 잡아", "이도경");

        Lombok lombok3 = new Lombok.LombokBuilder()
                // final 은 @Builder 에서 필수 체크값이 아님
                // : Lombok 이 내부에서 빌더 전용 생성자를 통해 생성 초기화를 우회
                .title("자바자바")
                // @Builder: @NonNull 이 있는 필드에 대해 값을 할당하지 않으면 NPE 발생함.
                .author("조승법")
                .build();

        System.out.println(lombok1);
        System.out.println(lombok2);
        System.out.println(lombok3);
    }
}
