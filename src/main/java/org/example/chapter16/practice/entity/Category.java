package org.example.chapter16.practice.entity;

public enum Category {
    FICTION, NONFICTION, SCIENCE, HISTORY, FANTASY;

    public static Category fromString(String value) {
        try {
            return Category.valueOf(value);
        } catch (IllegalArgumentException e) {
           throw new IllegalArgumentException("Invalid category: " + value);
        }
    }
}
