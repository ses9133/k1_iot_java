package org.example.chapter13;

/*
    1) 제네릭 사용 목적
    : 여러 타입을 하나의 코드로 처리하여 중복을 줄이고, 타입 안정성을 확보

    2) 와일드 카드 ? 사용시점
    : 타입을 알 수 없거나 타입 관계없이 처리할때 사용

    3) extends VS super 차이점
    : extends(상속받는 타입만 허용 - 읽기 전용)
    : super(조상 타입만 허용 - 쓰기, 읽기 가능)

    4) <? extends  > 에서 list.add(값) 이 안되는 이유
    : 와일드카드는 타입이 불확실해서 안정성 문제로 컴파일이 값의 할당을 막음
 */

// == 주문 관리 시스템 ==//
// 상품(Product) 과 할인(Discount) 정보를 관리
// : 할인 정책 사용시, Product 또는 Product 를 상속받는 하위클래스(Electronics / Furniture) 에서만 적용

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// 1. 상위 클래스
class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

// 2. 하위 클래스(Electronics / Furniture)
class Electronics extends Product {
    public Electronics(String name, int price) {
        super(name, price);
    }
}

class Furniture extends Product {
    public Furniture(String name, int price) {
        super(name, price);
    }
}

// 3. 할인 정책 클래스
class DiscountPolicy {
    public static double applyDiscount(List<? extends Product> products, double discountRate) {
        // Product 타입 이거나 하위 클래스(전자, 가구) 만을 허용
        double totalDiscount = 0.0;
        for(Product product : products) {
            double discount = product.getPrice() * discountRate;
            totalDiscount += discount;
            System.out.println(product.getName() + " 할인 적용:" + discount + "원");
        }
        return totalDiscount;
    }
}

public class C_Generic {
    public static void main(String[] args) {
        List<Electronics> electronics = new ArrayList<>();
        electronics.add(new Electronics("냉장고", 80000));
        electronics.add(new Electronics("세탁기", 70000));
        electronics.add(new Electronics("인덕션", 60000));

        // List<Product> -> List<Electronics> 로 형변환 가능?
        // : 제네릭 타입은 내부 요소의 형변환을 지원 X =>  공변성을 지원하지 않음

        // cf) 공변성
        // : 프로그램 타입 시스템 중 하나로 제네릭 타입에서 상위 타입 관계가 유지되는 것
        // > Electronics 가 Product 의 하위 클래스이지 "리스트 사이의 상속관계는 없다"
        // 타입매개변수(꺽쇠 괄호안)끼리는 아무리 상속관계에 놓인다한들 캐스팅이 불가능하다. -> 제네릭은 무공변이기 때문
        double totalElectronics = DiscountPolicy.applyDiscount(electronics, 0.1);
        System.out.println("총 가전 할인액: " + totalElectronics + "원");

        System.out.println();

        List<Furniture> furnitures = new ArrayList<>();
        furnitures.add(new Furniture("침대", 1000));
        furnitures.add(new Furniture("화장대", 2020));
        furnitures.add(new Furniture("소파", 120000));

        double totalFurnitures = DiscountPolicy.applyDiscount(furnitures, 0.2);
        System.out.println("총 가구 할인액: " + totalFurnitures + "원");

    }
}
