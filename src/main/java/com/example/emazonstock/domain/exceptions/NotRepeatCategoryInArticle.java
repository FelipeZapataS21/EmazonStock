package com.example.emazonstock.domain.exceptions;

public class NotRepeatCategoryInArticle extends RuntimeException {
    public NotRepeatCategoryInArticle(String message) {
        super(message);
    }
}
