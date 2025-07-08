package org.example.chapter07;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("1", "정은혜", "사원", 300);

        employee1.displayInfo();
        employee1.setPosition("대리");
        employee1.setPosition("");
        employee1.setSalary(-5000);

        employee1.displayInfo();
    }
}
