package org.example.test0710.자바OOP구현문제;

class Animal {
    String name;

   void makeSound() {

   }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("야옹");
    }
}

public class Q1 {
    public static void main(String[] args) {

//        Animal dog = new Dog();
//        Animal cat = new Cat();

        Animal[] animals = { new Dog(), new Cat() };

        for(Animal animal : animals) {
            animal.makeSound();
        }
    }
}
