package com.example.emazonstock.domain.exceptions;

public class ExceedNumberOfCategories extends RuntimeException {
    public ExceedNumberOfCategories(String message) {
        super(message);
    }
}
