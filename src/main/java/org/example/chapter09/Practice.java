package org.example.chapter09;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        // == 생일까지 남은 일수를 계산하는 프로그램 == //
        // : 사용자로부터 생년월일을 입력받고, 다가오는 생일까지 남은 일수를 반환
        Scanner sc = new Scanner(System.in);

        // 1. 사용자로부터 생년월일을 입력받기 (형식: YYYY-MM-DD)
        System.out.println("생년월일을 입력하세요: (YYYY-MM-DD)");
        String inputDate = sc.nextLine();

        // 2. 사용자의 입력을 LocalDate 타입으로 변환 (yyyy-MM-dd): formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // LocalDate.pares(a, b) => a 를 b 의 형태로 재구성
        LocalDate birthDate = LocalDate.parse(inputDate, formatter); // 1997-11-14
        System.out.println(birthDate);

        // 3. 현재 날짜
        LocalDate today = LocalDate.now(); // 2025-07-09

        // 4. 올해의 생일 계산
        // .withYear() : 년도를 조작하는 메서드
        // .with~()
        LocalDate nextBirthDay = birthDate.withYear(today.getYear()); // 2025-11-14
        System.out.println(nextBirthDay);

        // 5. 생일이 이미 지났거나 당일인 경우 년도값을 내년으로 설정
        if(nextBirthDay.isBefore(today) || nextBirthDay.isEqual(today)) {
            nextBirthDay = nextBirthDay.plusYears(1);
        }

        // 6. 남은 일수 계산
        // ChronoUnit.Days: java.time 패키지에서 날짜와 시간간의 차이를 계산할때 사용
        // .between(a, b): a 와 b 사이의 날짜 또는 시간차이를 반환해줌
        long days = ChronoUnit.DAYS.between(today, nextBirthDay);

        System.out.println("남은 생일까지 " + days + " 일 남았습니다.");
    }
}
