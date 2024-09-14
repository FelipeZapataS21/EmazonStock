package com.example.emazonstock.application.utils.dtoconstants;

public class ArticleDtoConstants {

    public static final String UTILITY_CLASS = "utility class";

    public static final String VALIDATION_NULL_DTO_NAME_ARTICLE =
            "The value 'name' of 'article' cannot be null";
    public static final String VALIDATION_NULL_DTO_DESCRIPTION_ARTICLE =
            "The value 'description' of 'article' cannot be null";
    public static final String VALIDATION_NULL_DTO_AMOUNT_ARTICLE =
            "The value 'amount' of 'article' cannot be null";
    public static final String VALIDATION_NULL_DTO_PRICE_ARTICLE =
            "The value 'price' of 'article' cannot be null";
    public static final String VALIDATION_NULL_DTO_BRAND_ARTICLE =
            "The value 'brand' of 'article' cannot be null";
    public static final String VALIDATION_NULL_DTO_CATEGORIES_ARTICLE =
            "The value 'categories' of 'article' cannot be null";

    private ArticleDtoConstants(){ throw new IllegalStateException(UTILITY_CLASS);}
}
