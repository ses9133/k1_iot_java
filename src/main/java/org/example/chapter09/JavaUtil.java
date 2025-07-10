package org.example.chapter09;

// java.util 패키지
// : 자바에서 가장 많이 쓰이는 기능을 모아놓은 패키지
// - 컬렉션 프레임워크 ,유틸리티, 날짜 및 시간 처리, 랜덤값 생성, 입력키 등,,

import java.util.Random;
import java.util.Scanner;

public class JavaUtil {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.close();

        Random random = new Random();   // 랜덤 객체 생성
        int num = random.nextInt();
        System.out.println(num);

        int num2 = random.nextInt(100); // bound 값 설정 가능 : 0 부터 N 사이의 난수
        System.out.println(num2);

        int num3 = random.nextInt(101, 200);
        System.out.println(num3);

    }
}
