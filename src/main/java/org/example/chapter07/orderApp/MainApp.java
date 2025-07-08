package org.example.chapter07.orderApp;

/*
    MainApp 클래스
    : 주문 시스템의 실행 진입점
    - 제품 생성, 주문 생성, 주문 결과 출력을 담당
 */
public class MainApp {
    public static void main(String[] args) {
        // 제품 생성
        Product laptop = new Electronics("Laptop",5000);
        Product apple = new Food("apple", 600);

        // 주문 생성
        Order order1 = new Order(laptop, 1);
        Order order2 = new Order(apple, 10);

        // 주문 결과
        System.out.println(order1);
        System.out.println(order2);




    }
}
