package org.example.chapter02;

import java.util.Scanner;

public class E_Pratice {
    public static void main(String[] args) {

        // 예제 1)
        Scanner sc = new Scanner(System.in);

        System.out.println("점수를 입력하세요: ");
        int score = sc.nextInt();

        if(score < 0 ||  score > 100) System.out.println("유효하지 않은 점수입니다.");
        else if(score >= 90) System.out.println("A");
        else if(score >= 80) System.out.println("B");
        else if(score >= 70) System.out.println("C");
        else if(score >= 60) System.out.println("D");
        else  System.out.println("F");

        // 예제 2)
        for(int i = 0; i < 5; i++) {
           for(int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        /*
            ....*
            ...**
            ..***
            .****
            *****
       */
        /*
            1) 공백은 하나씩 감소함 4,3,2,1,0
            2) *은 하나씩 증가함. 1,2,3,4,5
         */

        int rows = 5;
        for(int i = 1; i <= rows ; i++) {   // 각 행

            for(int j = 1; j <= rows - i; j++){     // 공백
                System.out.print(" ");
            }
            for(int k = 1; k <= i; k++){        // *
                System.out.print("*");
            }
            System.out.println();           // 줄바꿈
        }

        // 1행: i (1) 일 때 => j (4번 반복) , k(1번 반복) ,,,

        /*

        ..*
        .***
        *****

         */

        int row = 3;
        for(int i = 0; i < row; i++) {

            for(int j = 0; j < row - i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < i * 2 + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
