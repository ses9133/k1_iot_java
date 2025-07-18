package org.example.chapter12.model;

import java.time.LocalDateTime;

/**
 * @Field
 * 학생 고유 번호(studentId), 이름(name), 나이(age), 학번(studentNumber), 생성일(createdAt)
 *
 * @Method
 *  getter/setter, toString
 *
 * */

public class Student {
    private int studentId;
    private String name;
    private int age;
    private String studentNumber;
    private LocalDateTime createdAt;

    public Student(int studentId, String name, int age, String studentNumber) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.createdAt = LocalDateTime.now();
    }

    // getter
    public int getStudentId() { return studentId; }
    public String getName() { return name ; }
    public int getAge() { return age; }
    public String getStudentNumber() { return studentNumber; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // setter
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Student { ID= " + studentId + "학생 이름= " + name + ", 나이= " + age + ", 학번= " + studentNumber + ", 생성일= " + createdAt + " }";
    }
}
