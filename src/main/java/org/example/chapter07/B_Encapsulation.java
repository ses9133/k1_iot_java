package org.example.chapter07;

// == 캡슐화 == //
// : OOP 에서 데이터와 해당 데이터를 처리하는 함수(메서드)를 하나로 묶는 것을 의미
// - 객체 내부의 구현을 숨기고, 외부에서는 제공된 메서드를 통해서만 접근하도록 설정
// - 데이터 보호, 유지보수성 향상, 사용자 편의성 증대

// == getter & setter 메서드 == //
// : 캡슐화된 데이터에 안전하게 접근하고 수정할 수 있도록 하는 기능
// +) 데이터의 무결성 유지와 정보 은닉 담당

// cf) 데이터 보호 / 유지보수성 향상을 목적으로 데이터 필드(속성)을 private 선언
//      >> 데이터에 접근하거나 수정할 때는 getter & setter 메서드를 사용하는 체계활용

// 1) getter: 객체의 특정 필드 값을 "읽는" 메서드
//      get<필드명>();     ex) getName();, getStudentId();

// 2) setter: 객체의 특정 필드값을 "설정"하는 메서드
//      set<필드명>();     ex) setName(String name), setAge(int age), setStudentId(int studentId),

// == 예시 ) 학생 정보 관리 클래스 == //
class Student {
    private String name;
    private int residentNumber;
    private int age;
    private int score;

    // getter: private 필드값을 읽어 반환해줌
    public String getName() {
        return name;
    }
    public int getResidentNumber() {
        return residentNumber;
    }

    // cf) 단순한 데이터의 반환 뿐만 아니라, 데이터 가공 역할을 담당하기도 함.
    public String getAge() {
        if(age > 19) return "성인";
        else return "미성년자";
    }
    public int getScore() {
        return score;
    }

    // setter: 데이터를 받아 내부의 필드에 저장 (필드 타입의 매개 변수를 넣고, 반환타입 X)
    public void setName(String name) {
        this.name = name;

    }
    public void setResidentNumber(int residentNumber) {
        this.residentNumber = residentNumber;
    }

    // cf) setter는 단순한 데이터 설정뿐만 아니라, 데이터의 검증 역할을 담당하기도 함
    public void setAge(int age) {
        if(age < 0) System.out.println("유효하지 않은 나이입니다.");
        else this.age = age;
    }
    public void setScore(int score) {
       if(score >= 0 && score <= 100) this.score = score;
       else System.out.println("유효하지 않은 점수입니다.");
    }

}

public class B_Encapsulation {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("정은혜");
        student.setAge(-1); // 유효하지 않은 나이입니다.
        student.setAge(29);
        student.setScore(100);
        student.setResidentNumber(1234);
        student.setResidentNumber(98765421);
        System.out.println(student.getResidentNumber());
        // >> final 키워드(데이터의 불변성을 지키는 키워드) 로 바뀌면 안되는 값을 설정해야함.

        }
    }

 // cf) 언더스코어와 하이픈의 차이
// a_hello: 가독성을 위한 단어의 구분(단어가 1개)
// a-hello: 각 단어의 구분(단어가 여러개)

// ctrl + 좌우 방향키
// crtl + shift + 좌우방향키: 단어별 드래크


