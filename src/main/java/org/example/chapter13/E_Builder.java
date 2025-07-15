package org.example.chapter13;

/*
    === Builder 패턴 ===
    : 소프트웨어 설계 패턴의 객체 생성 방법 중 하나
    - 복잡한 객체를 단계별로 만들 때 사용
    - 필드가 많거나, 필드에 필수값과 선택값이 섞여 있을 때 유용하게 사용

    1. 사용 목적
    : 생성자가 너무 많아질 때
    : 코드가 복잡하고 읽기 어려울 때

    2. 장단점
       1) 장점: 가독성 향상, 유연성 증가, 확장성 용이
       2) 단점: 구현 복잡성 증가, 작은 객체에는 부적합

    3. 동작 원리
        1) 객체 생성시 필요한 데이터를 저장하는 Builder 클래스를 생성
        2) Builder 클래스는 원하는 속성을 단계별로 설정할 수 있는 메서드를 제공
        3) builder() 메서드 호출하여 객체를 생성

    4. 빌더 사용 방법
 */
class Pizza {
    // 두개는 필수사항
    private final String menu;
    private final String size;

    //선택사항
    private final boolean cheese;
    private final boolean mushroom;
    private final boolean pepperoni;

//    // 생성자 1
//    public Pizza(String menu, String size) {
//        this.menu = menu;
//        this.size = size;
//
//        // 선택사항은 기본값 처리
//        this.cheese = false;
//        this.mushroom = false;
//        this.pepperoni = false;
//    }
//
//    // 생성자 2
//    public Pizza(String menu, String size, boolean cheese, boolean mushroom, boolean pepperoni) {
//        this.menu = menu;
//        this.size = size;
//        this.cheese = cheese;
//        this.mushroom = mushroom;
//        this.pepperoni = pepperoni;
//    }

    // 1) Builder 클래스 정의 (Pizza 클래스 내부의 클래스)
    public static class Builder {
        // static 사용 이유: Pizza 클래스가 인스턴스화 되지 않았을 때 내부 Builder 클래스로 인스턴스화 진행할것이기 때문~!
        // 외부클래스명.내부클래스명(); 으로 바로 호출가능

        // 필수 필드
        private final String menu;
        private final String size;

        // 선택 필드 (추가하지 않으면 해당값으로 입력) (final 안하는 이유: 추가선택여부에 따라 값이 달라지기때문에)
        private boolean cheese = false;
        private boolean mushroom = false;
        private boolean pepperoni = false;

        // 필수값 초기화
        public Builder(String menu, String size) {
            this.menu = menu;
            this.size = size;
        }

        // 선택값 지정메서드
        public Builder addCheese() {
            this.cheese = true;
            return this;
        }

        public Builder addMushroom() {
            this.mushroom = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        // Builder 객체를 생성하는 build 메서드
        public Pizza build() {
            return new Pizza(this);
        }
    }

    // build()메서드에서 Pizza( " " ) 의 인자를 받을 수 있는 생성자 만들기
    private Pizza(Builder builder) {
        this.menu = builder.menu;
        this.size = builder.size;

        // add~(); 메서드 호출하지 않더라도 기본값 false 지정됨
        this.cheese = builder.cheese;
        this.mushroom = builder.mushroom;
        this.pepperoni = builder.pepperoni;
    }
}


public class E_Builder {
    public static void main(String[] args) {
        // Builder 안쓰면 Pizza p = new Pizza("파인애플피자", "L", "",...) 이렇게 생성해줘야함.

        Pizza builderPizza = new Pizza.Builder("고구마 피자", "M").build();

        Pizza optionalPizza1 = new Pizza.Builder("포테이토 피자", "S")    // Builder 인스턴스 생성
                .addCheese()    //Builder 인스턴스 메서드 호출 - 반환 Builder
                .addMushroom()  //Builder 인스턴스 메서드 호출 - 반환 Builder
                .build();       //Builder 인스턴스 메서드 호출 - 반환 Pizza

        Pizza optionalPizza2 = new Pizza.Builder("쉬림프 피자", "S").addCheese().addPepperoni().build();

        // cf) 메서드 체이닝
        //  : 메서드 호출뒤 반환되는 데이터에 곧바로 추가 메서드를 호출
        //  - 객체를 연결고리로하여 메서드를 지속적으로 호출

    }
}
