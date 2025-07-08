package org.example.chapter07.orderApp;

/*
    Order 클래스
    : 실제 주문 로직이 구현
    - 특정 제품과 수량을 기반으로 주문을 생성

    >> 총 가격(세금 포함) 을 계산하는 역할
 */
public class Order {
    private Product product;
    private int quantity;
    
    Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    // 총 가격 계산 메서드
    double calculateTotalPrice() {
        double tax = product.calculateTax();
        double totalPrice = (product.getPrice() + tax) * quantity;
        return totalPrice;
    }
    
    // 주문 정보 반환
    // : 모든 객체타입에 존재하는 메서드
    // - sout 에 객체(참조) 타입 출력시 해당 메서드가 실행됨
    // - 클래스 타입의 경우 참조 주소 값이 반환됨

    @Override
    public String toString() {
        return "Order Detail[" + product.getName() + " * " + "Quantity: " + quantity
                + " >> " + calculateTotalPrice() + " ]";
    }
    
    // cf) toString(); 오버라이딩
    //  - 객체를 문자열로 표현 할 때 사용함.(재정의하여 사용자 편의 문자 출력가능하도록 오버라이딩함)
    //  - 모든 클래스의 최상위 클래스인 Object 클래스에 정의되어있음

}
