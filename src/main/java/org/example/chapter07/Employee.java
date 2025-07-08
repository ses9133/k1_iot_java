package org.example.chapter07;


// 사원 정보 관리 시스템 //
public class Employee {
    final private String employeeId;
    private String name;
    private String position;
    private int salary;

    Employee(String employeeId, String name, String position, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        if(salary >= 0) this.salary = salary;
        else this.salary = 0;
    }

    void displayInfo() {
        System.out.println("사원 ID: " + employeeId + ", 이름: " + name + ", 직급: " + position + ", 급여: " + salary);

    }

    void setName(String name) {
        if(name == null || name.isEmpty()) ;
        else {
            this.name = name;
            System.out.println("이름을 " + name + " 으로 변경합니다.");
        }
    }

    void setPosition(String position) {
        if(position == null || position.isEmpty());
        else {
            this.position = position;
            System.out.println("직급을 " + position + " 으로 변경합니다.");
        }
    }

    void setSalary(int salary) {
        if(salary < 0) System.out.println("급여를 " + salary + "으로 변경시도합니다.");
        else {
            this.salary = salary;
            System.out.println("급여를 " + salary + "로 변경시도합니다.");
        }
    }

    String getName() {
        return name;
    }

    String getPosition() {
        return position;
    }

    int getSalary() {
        return salary;
    }

    String getEmployeeId() {
        return employeeId;
    }

}
