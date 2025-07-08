package org.example.chapter07.orderApp;
/*
 * Product 클래스
 *
 * - Field: name(제품명), price(제품가격)
 * - Constructor: Product(name, price)
 * - Method: getName(), getPrice() - getter
 * 			/ calculateTax(): 세금 계산 메서드(기본 10% 세율)
 * */
public class Product {
    private String name;
    private int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    double calculateTax() {
        return getPrice() * 0.1;
    }
}
