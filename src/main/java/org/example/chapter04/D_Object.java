package org.example.chapter04;

class Book {
    // 1. 데이터(필드)
    String title;
    String publisher;
    int pageNumber;

    // 2. 메서드
    void displayInfo() {
        System.out.println(title + " " + publisher);
        // void: 반환값이 없는 경우 - return 생략 || return;

        // cf) 반환값이 있는 경우: return 반환값;

        // >> return 키워드는 해당 메서드의 종료를 의미
        return;
        // System.out.println("실행안됨"); -> 해당코드에 접근 불가
    }

    // 3. 생성자
    // : 반드시 하나의 class 내부에는 한 개 이상의 생성자가 존재해야함.
    // - new 연산자를 사용하여 호출 될 메서드
    // - 필드값 초기화에 주로 사용
    //      >> 생략시 속성의 기본값이 할당됨     // 37~39 번 line 참고

    // +) 사용자 정의 생성자 메서드 생략시
    //      >> 클래스명과 동일하면서 '매개변수'와 '동작'이 없는 메서드가 생략됨.
    Book() {

    }

    Book(String title, String publisher, int pageNumber) {
        this.title = title;
        this.publisher = publisher;
        this.pageNumber = pageNumber;
    }

}
public class D_Object {
    public static void main(String[] args) {
        Book myBook1 = new Book();
        System.out.println(myBook1.title);
        System.out.println(myBook1.publisher);
        System.out.println(myBook1.pageNumber);

        Book myBook2 = new Book("백설공주", "코리아출판사", 50);
        Book myBook3 = new Book("신데렐라", "에이원플라자", 100);

        System.out.println(myBook2.title);
        System.out.println(myBook3.title);

        myBook1.displayInfo();
        myBook2.displayInfo();
        myBook3.displayInfo();

        myBook1.title = "개구리왕자";
        myBook1.publisher = "개굴출판사";
        myBook1.displayInfo();

        myBook2.title = "백설공주2탄";   // 값 변경 가능함.
        myBook2.displayInfo();
    }
}
