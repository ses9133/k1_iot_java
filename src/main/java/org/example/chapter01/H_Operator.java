package org.example.chapter01;

public class H_Operator {
    public static void main(String[] args) {
        // === 연산자(Operation) === //
        // : 프로그램에서 데이터를 조작하거나 계산

        System.out.println("=== 산술 연산자 ===");
        // 사칙 연산(덧셈, 뺄셈, 곱셈, 나눗셈)
        int a = 10;
        int b = 20;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b); // 나눗셈(/) : 나눈 결과의 몫을 저장
        System.out.println(a % b); // 나눗셈(%) : 나눈 결과의 나머지를 저장

        System.out.println("=== 증감 연산자 ===");
        // : 변수의 값을 1 증가(++) 시키거나 1 감소(--) 시키는 연산자
        int number = 10;

        // 1) 전위 증감 연산자
        // : 값이 먼저 변경되고 나서 계산에 적용
        // : ++변수명, --변수명
        System.out.println(++number); // 증가 후 출력됨
        System.out.println(--number); // 감소 후 출력됨

        // 2) 후위 증감 연산자
        // : 값이 계산된 이후 변경
        // : 변수명++, 변수명--
        System.out.println(number++);   // 출력후 +1 증가
        System.out.println(number--);   // 출력후 -1 감소
        System.out.println(number);     // -1 감소

        number++;   // 10(+1)
        number++;   // 11(+1)
        ++number;   // 13
        --number;   // 12
        number--;   // 12
        number++;   // 11
        System.out.println(number); // 12

        System.out.println("=== 대입(할당) 연산자 ===");
        // : 변수에 값을 할당할 때 사용하는 연산자
        // 기본 연산자(=), 사칙연산과 결합된 연산자(+=, -=,, *=, /=,, %=)
        number = 10;

        // 해당 값의 연산 후 다시 변수에 할당
        System.out.println(number += 3);    // number + 3 의 결과를 number 에 할당(number = number + 3)
        System.out.println(number -= 3);    // number = number - 3
        System.out.println(number *= 3);    // 30
        System.out.println(number /= 3);    // 10
        System.out.println(number %= 3);    // 1
        System.out.println(number);

        System.out.println("=== 비교 연산자 ===");
        // : 좌항과 우항을 비교한 결과를 논리(boolean)값으로 반환
        // <, >, <= >= ==, !=
        System.out.println(5 > 3);
        System.out.println(5 < 3);
        System.out.println(5 >= 3);
        System.out.println(5 <= 3);
        System.out.println(5 != 3);

        System.out.println("=== 논리 연산자 ===");
        // : 논리값(boolean) 을 연산

        // & (앰퍼샌드), | (버티컬 바)
        // 1) 논리곱 (and, &&)
        // : 모든 값이 true 면 true return
        // - 하나의 값이라도 false 이면 false 반환
        System.out.println(true && true && true);
        System.out.println(true && true && true && false && true && true);

        // 2) 논리합(or, ||)
        // : 하나의 값이라도 true 면 true return
        System.out.println(true || true);
        System.out.println(true || true || false);
        System.out.println(false || false || false);

        // 3) 부정 논리(!)
        // : 논리값을 전환
        // : 논리값앞에 ! 사용
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(!bool1);
        System.out.println(!bool2);

        System.out.println(3 > 2 && 1 == 1);
        System.out.println(1 != 1);
        System.out.println(3 >= 3 || 10 < 11 && !bool2);

        System.out.println("=== 조건(삼항) 연산자 ==="); // 중요 ****
        //  조건식(논리의 값이 반환) ? 조건식이 참인 경우 반환 : 조건식이 거짓인 경우 반환

        int age = 10;
        String drink = age > 19 ? "맥주" : "오렌지 주스";
        System.out.println(drink + "을(를) 마십니다.");

        int x = 10, y = 3; // 변수의 데이터 타입이 같은 경우, 콤마로 구분하여 나열 가능
        System.out.println(x % y == 0 ? "2의 배수 입니다." : "2의 배수가 아닙니다");

        System.out.println("=== 기타 연산자 ===");
        // 문자열 연결 연산자 +
        String result = "정" + "은혜";
        System.out.println(result);

        // cf) 연산자의 우선순위
        // : (기본) 좌측 -> 우측
        //      그러나 !! 대입 연산자의 경우 우항에서 좌항의 대입이 이루어짐.
        //      () 괄호 연산자의 경우 우선순위를 가짐
    }
}
