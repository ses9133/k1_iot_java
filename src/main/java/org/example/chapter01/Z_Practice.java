package org.example.chapter01;

import java.util.Scanner;

public class Z_Practice {
    public static void main(String[] args) {
        /*
        === 복합 복습 문제 ===
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : " );
        String name = sc.nextLine();
        System.out.print("국어점수 : " );
        int korScore = sc.nextInt();
        System.out.print("영어점수 : " );
        int engScore = sc.nextInt();
        System.out.print("수학점수 : " );
        int mathScore = sc.nextInt();

        int totalScore = korScore + engScore + mathScore;
        double avgScore = totalScore / 3.0 ;
        String pass = (korScore >= 60 && engScore >= 60 && mathScore >= 60) ? "합격" : "불합격";

        System.out.println("[이름 : " + name + "]");
        System.out.println("총점: " + totalScore);
        System.out.println("평균: " + avgScore);
        System.out.println("합격여부 : " + pass);

        sc.close();

    }
}
