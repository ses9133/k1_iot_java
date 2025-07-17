package org.example.book_management_system.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String format(LocalDateTime localDateTime) {
        return localDateTime.format(FORMATTER);
    }

    public static String now() {
        return LocalDateTime.now().format(FORMATTER);
    }

}
