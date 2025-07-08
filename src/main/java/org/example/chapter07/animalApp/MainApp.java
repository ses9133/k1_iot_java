package org.example.chapter07.animalApp;

import java.util.ArrayList;

// == 동물 관리 시스템 == //
public class MainApp {
    public static void main(String[] args) {
        // == 서비스 계층(실행) 생성 == //
       AnimalService service = new AnimalService();

       // 동물을 관리하는 List
        ArrayList<Animal> animals = new ArrayList<>();

        // 동적 배열에 객체를 추가
        // : Animal 타입에 Cat/Dog 추가
        animals.add(new Cat());     // 생성하면서 바로 업캐스팅
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cat());

        // 배열의 모든 동물을 service 에 전달해서 출력
        for(Animal animal : animals) {
            if(animal instanceof Cat) {
                System.out.println("고양이가 있다!!");
                Cat cat = (Cat) animal; // 다운 캐스팅
                cat.eat();              // 다운 캐스팅 하면 자식 클래스의 고유 메서드에 대해 접근 가능해짐.
                System.out.println("----");
            }
            service.handleAnimal(animal);
        }

        // 객체 생성 및 처리
        Animal cat = new Cat();
        Animal dog = new Dog();

        service.handleAnimal(cat);
        service.handleAnimal(dog);

       // cat.eat(); 업캐스팅시에는 자식 고유의 메서드는 사용불가능하기 때문
        if(cat instanceof Cat) {
            Cat onylCat = (Cat) cat;    // 다운 캐스팅 해줘야 자식 고유의 메서드 사용 가능
            onylCat.eat();
        }

        if(dog instanceof Dog) {
            Cat dogCat = (Cat) dog;
            dogCat.eat();
            System.out.println("출력"); // 강아지는 고양이의 인스턴스가 아니기때문에 ClassCastException 예외처리 발생
        }

    }
}
