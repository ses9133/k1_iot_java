package org.example.test0710.자바OOP구현문제;

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        if(age < 0) System.out.println("나이는 0보다 작을 수 없습니다.");
        else this.age = age;
    }

}

public class Q2 {
    public static void main(String[] args) {

        Person person = new Person();

        person.setAge(29);
        person.setName("정은혜");
        System.out.println(person.getAge());
        System.out.println(person.getName());

        Person person2 = new Person();

        person2.setAge(-1); //나이는 0보다 작을 수 없습니다.


    }
}
