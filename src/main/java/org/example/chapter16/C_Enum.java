package org.example.chapter16;

/*
    == ENUM 메서드 오버라이딩 ==
    : ENUM 은 상수별 다른 동작을 정의
    - abstract 메서드를 선언한고 상수별 구현이 가능

 */


enum Operation {
    // enum 은 상수값 정의가 먼저 되어야함
    ADD {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    }; // -> 상수값 종료는 세미콜론으로

    public abstract int apply(int x, int y);
}

enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

//    SPRING("봄"),
//    SUMMER("여름"),
//    AUTUMN("가을"),
//    WINTER("겨울");

//    private final String seasonName;
//
//    Season(String seasonName) {
//        this.seasonName = seasonName;
//    }
//
//    public String getSeasonName() {
//        return seasonName;
//    }
}

public class C_Enum {
    public static void main(String[] args) {
        System.out.println(Operation.ADD.apply(3 , 5));
        System.out.println(Operation.SUBTRACT.apply(3 , 5));
        System.out.println(Operation.MULTIPLY.apply(3 , 5));

        Season season = Season.WINTER;

        switch (season) {
            case SPRING:
                System.out.println("봄");
                break;
            case SUMMER:
                System.out.println("여름");
                break;
            case AUTUMN:
                System.out.println("가을");
                break;
            case WINTER:
                System.out.println("겨울");
                break;
        }
    }
}
