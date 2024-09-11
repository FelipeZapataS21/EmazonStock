package com.example.emazonstock.application.utils.dtoconstants;

public class PageResultDtoConstants {

    private PageResultDtoConstants(){throw new IllegalStateException("Utility Class");}

    public static final String VALIDATION_NULL_DTO_CURRENT_PAGE =
            "The value 'currentPage' cannot be null";
    public static final String VALIDATION_NULL_DTO_PAGE_SIZE =
            "The value 'pageSize' cannot be null";
    public static final String VALIDATION_NULL_DTO_SORT =
            "The value 'sort' cannot be null";
    public static final String VALIDATION_POSITIVE_NUMBER_CURRENT_PAGE =
            "The value 'currentPage' must be 0 or greater";
    public static final String VALIDATION_POSITIVE_NUMBER_PAGE_SIZE =
            "The value 'pageSize' must be 0 or greater";
}
