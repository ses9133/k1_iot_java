package org.example.chapter16;

/*
   === Wrapper 클래스 ===
   : 기본 데이터 타입을 객체로 다루기 위해 사용

   cf) 기본 데이터 타입
   byte, short, int, long, char, float, double, boolean (+ void 메서드 반환)
   >> 각 데이터 타입에 해당하는 Wrapper 클래스가 존재

   cf) java.lang 패키지에 정의되어있음.
        : 컬렉션 프레임워크에서는 내부에 객체만을 저장
        - > 기본 타입을 Wrapper 클래스로 변환하여 저장해야함
        >> Integer, Character,,,

    == 박싱 (Boxing) & 언박싱(UnBoxing) -===
    : 기본타입과 해당 타입의 Wrapper 클래스 간의 자동 변환
    - 자바의 컴파일러가 자동 처리

    1) Boxing
    : 기본 타입 -> Wrapper 클래스로 변환
    2) UnBoxing
    : Wrapper 클래스 -> 기본타입으로 변환

    +) 장단점
    - 장점: 기본타입과 객체 타입 간의 호환이 용이
    - 단점: 객체 생성 과정에서 메모리 사용량이 증가(박싱, 언박싱 과정에서 성능 저하)
           null 값이 할당될 수 있는 Wrapper 객체를 언박싱할 경우 NPE 발생 위험 있음
 */

public class A_Wrapper {
    public static void main(String[] args) {
        // 1) 박싱
        int i = 5;
        Integer iObj = i;
        System.out.println(iObj); // 5

        // 2) 언박싱 (Wrapper -> 기본 클래스)
        // Wrapper 객체 생성: 객체타입.valueOf();
        Integer integerVal = Integer.valueOf(15);
        int iVal = integerVal;
        System.out.println(iVal); // 15

        // === Wrapper 클래스의 내부 메서드 === //
        // cf) toString() 메서드 등
        Integer myInteger = Integer.valueOf(20);

        // 1) intValue(): Integer 객체 -> int 타입
        int myInt = myInteger.intValue();
        System.out.println(myInt);

        Object obj = Integer.valueOf(100);
       // int x = obj; -> 자동 언박싱 불가.
        int x = ((Integer)obj).intValue();

        Integer a = null;
       // int abc = a; // NPE
        int abc = (a != null) ? a.intValue() : 0; // 안전하게 기본 값 처리
        System.out.println(abc);

        // 2) parseInt(String s) : 문자열을 기본 int 타입으로 파싱
        // String -> Integer -> int
        int paresIntVal = Integer.parseInt("123");
        System.out.println(paresIntVal); // 123

        //int parseIntVal2 = Integer.parseInt("abc");
        // System.out.println(parseIntVal2); // NumberFormatException

        // 3) a.compareTo(Integer anotherInt)
        // : 두 Integer 객체를 비교해서 같으면 0, 호출 객체(a)가 더 크면 양수, 작으면 음수 반환
        Integer anotherInt = Integer.valueOf(200);
        int result = myInteger.compareTo(anotherInt);
        System.out.println(result); // -1


































    }
}
