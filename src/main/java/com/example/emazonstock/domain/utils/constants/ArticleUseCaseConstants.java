package com.example.emazonstock.domain.utils.constants;

public class ArticleUseCaseConstants {

    public static final Integer LIMIT_OF_CATEGORIES_IN_ARTICLE = 3;
    public static final String EXCEPTION_UTILITY_CLASS =
            "Utility class";

    private ArticleUseCaseConstants() {
        throw new IllegalStateException(EXCEPTION_UTILITY_CLASS);
    }
}
