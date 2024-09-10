package com.example.emazonstock.application.utils;

public class DtoCategoryConstants {
    public static final String VALIDATION_NULL_DTO_NAME_CATEGORY =
            "The value 'name' of 'category' cannot be null";
    public static final String VALIDATION_NULL_DTO_DESCRIPTION_CATEGORY =
            "The value 'description' of 'category' cannot be null";
    public static final String VALIDATION_CATEGORY_EMPTY_OR_LONGER =
            "The category name cannot be empty or longer than 50 characters";
    public static final String VALIDATION_DESCRIPTION_EMPTY_OR_LONGER =
            "Description of category cannot be empty or longer than 70 characters";
    public static final String VALIDATION_NULL_DTO_CURRENT_PAGE =
            "The value 'currentPage' cannot be null";
    public static final String VALIDATION_NULL_DTO_PAGE_SIZE =
            "The value 'pageSize' cannot be null";
    public static final String VALIDATION_NULL_DTO_SORT =
            "The value 'sort' cannot be null";
    public static final String VALIDATION_POSITIVE_NUMBER_CURRENT_PAGE =
            "The value 'currentPage' must be 0 or greater";
    public static final String VALIDATION_POSITIVE_NUMBER_PAGE_SIZE =
            "The value 'pageSize'must be 0 or greater";

    private DtoCategoryConstants() {
        throw new IllegalStateException("Utility class");
    }

}
