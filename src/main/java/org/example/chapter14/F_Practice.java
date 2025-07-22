package org.example.chapter14;

/*
    === 학생 점수 처리 시스템 ===
    : 람다식 및 주요 함수형 인터페이스를 사용

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class F_Practice {
    public static void main(String[] args) {
        // [1] 학생이름과 점수를 저장할 Map
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("김지선", 90);
        studentScores.put("김동후", 80);
        studentScores.put("권지애", 95);
        studentScores.put("박현우", 85);
        studentScores.put("김승민", 100);

        // [2] Predicate: 점수가 90점 이상인지 판단하는 조건 함수
        Predicate<Integer> isPass = score -> score >= 90;

        // [3] Function: 점수를 등급으로 변환하는 함수
        Function<Integer, String> gradeFunction = score -> {
            if(score > 100 || score < 0) return "X";
            else if(score >= 90) return "A";
            else if(score >= 80) return "B";
            else if(score >= 70) return "C";
            else return "F";
        };

//        Function<Integer, String> gradeFucntion = new Function<Integer, String>() {
//            @Override
//            public String apply(Integer score) {
//                if(score > 100 || score < 0) return "X";
//                else if(score >= 90) return "A";
//                else if(score >= 80) return "B";
//                else if(score >= 70) return "C";
//                else return "F";
//            }
//        };

        // [4] Consumer: 콘솔에 출력하도록 하는 함수
        // 1) 전달받은 문자열 길이만큼  '=' 문자 출력 (구분선 용도)
        Consumer<String> line = s -> System.out.println("=".repeat(s.length()));    // .repeat(int )

        // 2) 제목을 꾸며서 출력하는 함수
        Consumer<String> printHeader = title -> {
            line.accept(title); // 상단 구분선
            System.out.println(title); // 제목 출력
            line.accept(title); // 하단 구분선
        };

        // 3) 학생 1명 정보를 출력하는 함수(이름, 점수 ,등급, 합격 여부)
        Consumer<Map.Entry<String, Integer>> printStudentInfo = entry -> {
            String name = entry.getKey();
            int score = entry.getValue();
            String grade = gradeFunction.apply(score);
            boolean pass = isPass.test(score);

            System.out.println(name + " | 점수 " + score + " | 등급: " + grade + " | " + (pass ? "합격 " : "불합격"));
        };

        // cf) Map.Entry<String, Integer>
        //      : Map 인터페이스 안에 정의된 중첩 인터페이스
        //      - Map 의 각 "키=값" 쌍을 나타내는 객체
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);    // "Apple" => 3 (사과는 3개) 라는 형식으로 map 내부에 저장 => 각 요소를 Map.Entry<String, Integer> 타입으로 다룰 수 있음.
        map.put("Banana", 5);

        // [5] Supplier: 무작위 보너스 점수를 생성하는 공급자 함수
        // 0 ~ 5 점중 하나를 반환
        // Random() 클래스의 .nextInt(N): 0 이상 N 미만의 점수를 반환
        Supplier<Integer> bonusSupplier = () -> new Random().nextInt(6);

        // [6] 프로그램 실행 - 제목 출력
        printHeader.accept("학생 점수 처리 결과");

        // [7] Map 의 entrySet() 을 사용해 전체 학생 처리
        // - entrySet(): 키와 값의 쌍을 순회할 수 있또록 Set<Map.Entry> 형태를 반환
        studentScores.entrySet().forEach(entry -> {
            // 무작위 보너스 점수 생성 + 기존점수에 더함
            int bonus = bonusSupplier.get();
            entry.setValue(entry.getValue() + bonus);

            printStudentInfo.accept(entry);
        });

    }
}
/*
    Predicate<T> (조건판단) : score >= 70
 */


