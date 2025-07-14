package org.example.chapter12.controlelr;

import org.example.chapter12.dto.StudentRequestDto;
import org.example.chapter12.dto.StudentResponseDto;
import org.example.chapter12.model.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 학생 데이터를 저장 + 6가지 기능 수행
 * CR(전체 / 단건)UD, 종료
 * */
public class StudentController {
    private final List<Student> studentList;
    private int nextId;

    public StudentController(List<Student> studentList) {
        this.studentList = studentList;
        this.nextId = studentList.size() + 1;
    }

    // 학생 생성
    public void addStudent(StudentRequestDto dto) {
        // 학생 추가시 입력한 studentId 가 이미 존재하는 경우, 오류 메시지 출력
        StudentResponseDto studentResponseDto = getStudentById(dto.getStudentNumber());

        if(studentResponseDto != null) {
            System.out.println("해당 학번의 학생이 이미 존재합니다.");
            return;
        }

        Student student = new Student(nextId++, dto.getName(), dto.getAge(), dto.getStudentNumber());
        studentList.add(student);
        System.out.println(dto.getName() + " 학생이 추가되었습니다. 학번: " + dto.getStudentNumber());

    }

    // 학생 조회(단건)
   public StudentResponseDto getStudentById(String studentNumber) {
        for(Student student : studentList) {
            if(student.getStudentNumber().equals(studentNumber)) {
                return new StudentResponseDto(student.getName(), student.getAge(), student.getStudentNumber(), student.getCreatedAt());
            }
        }
        // 학생 없으면
        return null;
   }

    // 학생 조회(전체)
    public List<StudentResponseDto> getAllStudents() {
        List<StudentResponseDto> response = new ArrayList<>();
        for(Student student: studentList) {
           response.add(new StudentResponseDto(student.getName(), student.getAge(), student.getStudentNumber(), student.getCreatedAt()));
        }
        return response;
    }

    // 학생 업데이트
    public boolean updateStudent(StudentRequestDto dto) {
        for(Student student : studentList) {
            if(student.getStudentNumber().equals(dto.getStudentNumber())) {
                student.setName(dto.getName());
                student.setAge(dto.getAge());
                return true;
            }
        }
        return false;
    }

    // 학생 삭제
    public boolean deleteStudent(String studentNumber) {
        for(Student student : studentList) {
            if(student.getStudentNumber().equals(studentNumber)) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }
}
