package org.example.chapter09_practice.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  클래스, 메서드 단위의 설명을 첨부하는 주석 (문서 주석)
 * @param 매개변수 작성
 * @return 반환값 작성
 * @throws
 * @exception
 * */

/*
    날짜 및 시간을 포맷팅하거나 파싱하는 유틸리티 클래스
 */

public class DateUtil {

    // 사용할 날짜 및 시간 포맷 패턴 정의
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    // 위의 패턴을 기반으로 하는 포맷터
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    /**
     * 현재 시간을 포맷된 문자열로 반환
     * @return 현재시간
     * */
    public static String now() {
        return LocalDateTime.now().format(FORMATTER);
    }

    /**
     * 전달받은 LocalDateTIme 객체를 포맷 문자열로 변환
     * @param dateTime 포맷할 LocalDateTime 객체
     * @return 포맷된 날짜 문자열
     * */
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }

    /**
     *  문자열 형태의 날짜를 LocalDateTime 객체로 파싱
     *  @param datetimeStr 포맷에 맞는 날짜 문자열
     *  @return LocalDateTime 객체
     * */
    public static LocalDateTime parse(String datetimeStr) {
        return LocalDateTime.parse(datetimeStr, FORMATTER);
    }

}
