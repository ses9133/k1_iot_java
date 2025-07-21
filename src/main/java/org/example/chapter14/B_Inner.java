package org.example.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;

// == 학교 시스템 == //
@Getter
@AllArgsConstructor
class School {
    private String schoolName;

    // (비정적) 내부 클래스 - 학생
    @AllArgsConstructor
    class Student {
        private int studentId;
        private String studentName;

        public void displayInfo() {
            System.out.println("학교명:" + schoolName + ", 학생 이름: " + studentName);
        }
    }

    // 정적 내부 클래스 - 교장선생님 (싱글톤 패턴 활용해보기)
    static class Principal {
        private static Principal instance;

        private Principal() {

        }

        public static Principal getInstance() {
            if(instance == null) instance = new Principal();
            return instance;
        }

        public void displayInfo() {
            System.out.println("훈화말씀 : ~~");
        }
    }

}

public class B_Inner {
    public static void main(String[] args) {
        School school = new School("명륜초등학교");

        // 비정적 내부 클래스
        // 외부클래스타입.내부클래스타입 변수명 = 외부클래스객체명.new 내부클래스();
        School.Student student1 = school.new Student(43, "정은혜");
        student1.displayInfo();

        // 정적 내부 클래스
        //외부클래스타입.내부클래스타입 변수명 = new 외부클래스명.내부클래스명();
        // getInstance() 가 없으면 School.Principal principal1 = new School.Principal(); 인데,
        // getInstance() 내부의 new 연산자의 사용으로 new 키워드 생략
        School.Principal principal1 = School.Principal.getInstance();
        principal1.displayInfo();

    }
}
