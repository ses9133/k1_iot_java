package org.example.chapter02;

import java.util.Scanner;

public class D_While {
    public static void main(String[] args) {
        // === while 문 === //
        // : 반복 횟수가 정해져있지 않을 때 사용

        // - 조건을 검사하고 해당 조건이 true 인 경우 코드 블록을 (반복적) 실행
        //      : if 문의 반복 형태

        /*
            while (조건식) {
                조건이 참인 경우 실행
            }

            >> for 문의 초기화식과 증감식이 조건문과 분리된 형태
                : for(초기화식; 조건식; 증감식) {
                }
         */

        // cf) for 문으로 1부터 5까지 출력하는 문장을 작성(초기화는 1)
        System.out.println("====for문 출력===");
        for(int i = 1; i <= 5; i++) {
            System.out.print(i);
        }

        System.out.println();

        // while 문으로 1부터 5까지 출력
        System.out.println("=== while 문 출력 ===");
        int num = 1;     // 초기화식
        while (num <= 5) {   // () 내에서 조건식
            System.out.print(num);    // 실행문
            num++;// 중괄호 내 증감식
        }

        // == 예제(break, continue) == //
        // 0 부터 20 까지의 정수 중에서 홀수만 출력

        // 1) break
        // : 반복문 내에서 break; 키워드를 만나면 반복문 탈출(종료됨)

        // 2) continue
        // : 반복문 내에서 continue; 키워드를 만나면 아래의 코드를 무시하고 다시 '조건 검사' 로 돌아감.

        System.out.println();

        // 초기화 (while 문 시작 전에 초기화되어야함)
        int number = 0;

        while (true) {   // if문 & while 문의 조건식은 결과값이 논리형이어야함
            // : while 문은 조건식을 true 값으로 고정하는 경우,
            //          종료시점을 개발자가 직접 명시하지 않으면 무한 루프 발생 . 실행중지 단축키(ctrl + F2)
            // >> 프로그램의 과부화 방지를 위해 지양

            if (number % 2 == 0) {
                number++;
                continue;   // 조건식으로 다시 돌아감!
            }

            // 홀수만 실행됨.
            System.out.println(number);
            number++;

            if (number == 20) break;
        }

        // cf) do-while 문
        // : while 문과의 차이점 - 코드가 반드시 한 번은 실행
        // : while 공통점 - 초기화식 & 증감식이 분리
        System.out.println("=== do-while 문 출력 ===");

        /*
            do {
                실행문;
            } while (조건);
         */

        int doNum = 1;

        do {
            System.out.println(doNum);
            doNum++;
        } while (doNum <= 5);

        int a = 6;
        while (a < 5) {
            System.out.println(a);
        }

        do {
            System.out.println(a);
        } while (a < 5);

        // == while VS do-while === //
        // 1) while 문
        // : 조건 검사 시점 - 실행 <전> 검사
        // : 최소 실행 횟수 - X (아예 실행이 안될 수도 있음)

        // 2) do-while 문
        // : 조건 검사 시점 - 실행 <후> 검사
        // : 최소 실행 횟수 - 1번 (1번은 무조건 실행됨)

        // === 예제 === //
        // : 사용자의 입력을 받아 1 ~ 10 사이의 숫자가 입력될 때 까지 반복
        // : do-while 문으로 작성
        Scanner sc = new Scanner(System.in);
        int inputNumber;

        do {
            System.out.println("1부터 10사이의 숫자를 입력하세요 :");
            inputNumber = sc.nextInt();
        } while(inputNumber < 1 || inputNumber > 10);   // 1 ~ 10 사이인 경우 반복문 종료

        System.out.println("올바른 숫자: " + inputNumber);

        // cf) while 문은 반복 전에 조건을 검사하기 때문에 초기 입력 코드를 반복문 밖에 따로 작성
        //      => 사용자 입력 받는 구문은 do-while 문이 코드 중복을 방지함.
        System.out.println("1 ~ 10 사이의 숫자를 입력하세요: ");
        inputNumber = sc.nextInt();

        while (inputNumber < 1 || inputNumber > 10) {
            System.out.println("다시 입력하세요. (1~ 10)");
            inputNumber = sc.nextInt();     // 122, 126 코드가 반복됨.
        }
    }
}
