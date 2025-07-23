package org.example.chapter15.a_practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 파일 데이터에 대한 데이터 분리 & 정렬
public class Practice02 {
    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList(
            "a.pdf", "b.png", "c.mp4"
            , "g.ppt", "h.js", "i.jpg"
            , "d.ppt", "e.png", "f.jpg"
        );

        // 1. 특정 확장자 필터링
        // : 이미지 파일만 추출(.png, .jpg)
        // cf) startsWith(""), endsWith("") : 특정 문자열로 시작, 끝나는 데이터에 대해 boolean 반환\
        List<String> filteredFiles = fileNames.stream()
                .filter(name -> name.endsWith(".png") || name.endsWith(".jpg"))
                .sorted()
                .collect(Collectors.toList());
        System.out.println(filteredFiles); // [b.png, e.png, f.jpg, i.jpg]

        // 효율적인 실행 순서 : filter -> sorted

        // 2. 파일 이름을 알파벳 순 정렬
        List<String> sortedFiles = fileNames.stream()
                .sorted()
                .toList();
        System.out.println(sortedFiles);

        List<String> sortedFilesRev = fileNames.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(sortedFilesRev); // [i.jpg, h.js, g.ppt, f.jpg, e.png, d.ppt, c.mp4, b.png, a.pdf]


    }
}
