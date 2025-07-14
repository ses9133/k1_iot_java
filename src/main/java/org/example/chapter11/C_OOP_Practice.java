package org.example.chapter11;

/*
    === SOLID 원칙 ===
    SRP, OCP, LSP, ISP, DIP
 */

// == SOLID 원칙을 활용한 주문 관리 시스템 == //
// 1. SRP - Order 클래스는 주문 정보를 저장하는 역할만 담당
class Order {
    private String orderId;
    private int amount;

    public Order(String orderId, int amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
    public String getOrderId() {
        return orderId;
    }
    public int getAmount() {
        return amount;
    }
}

// 2. OCP - 결제프로세스를 추상화한 인터페이스
interface PaymentProcessor {
    void processPayment(Order order);
}

class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(Order order) {
        System.out.println("신용카드로 결제합니다: " + order.getOrderId());
    }
}

class SamsungPayPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(Order order) {
        System.out.println("삼성페이로 결제합니다: " + order.getOrderId());
    }
}

// 3. ISP - 주문보고서 생성을 위한 별도의 인터페이스
interface GenerateReport {
    void generateReport(Order order);
}

class PdfReportGenerator implements GenerateReport {
    @Override
    public void generateReport(Order order) {
        System.out.println("주문 정보 보고서를 PDF 파일로 생성: "  + order.getOrderId());
    }
}

// 4. DIP - orderService 클래스는 결제 및 보고서 생성 인터페이스에 의존
class OrderService {
    private final PaymentProcessor paymentProcessor;
    private final GenerateReport generateReport;

    public OrderService(PaymentProcessor paymentProcessor, GenerateReport generateReport) {
        this.paymentProcessor = paymentProcessor;
        this.generateReport = generateReport;
    }

    void placeOrder(Order order) {
        // 결제 처리
        paymentProcessor.processPayment(order);
        // 주문 보고서 처리
        generateReport.generateReport(order);
        System.out.println("주문 완료");
    }

}
public class C_OOP_Practice {
    public static void main(String[] args) {
        PaymentProcessor creditCardPaymentProcessor = new CreditCardPaymentProcessor();
        PaymentProcessor samsungPayPaymentProcessor = new SamsungPayPaymentProcessor();

        GenerateReport generateReport = new PdfReportGenerator();

        OrderService orderService1 = new OrderService(creditCardPaymentProcessor, generateReport);
        OrderService orderService2 = new OrderService(samsungPayPaymentProcessor, generateReport);

        Order order1 = new Order("1", 18);
        Order order2 = new Order("2", 20);
        Order order3 = new Order("3", 50);
        Order order4 = new Order("4", 15);

        orderService1.placeOrder(order1);
        orderService1.placeOrder(order2);
        orderService2.placeOrder(order3);
        orderService2.placeOrder(order4);

    }
}
