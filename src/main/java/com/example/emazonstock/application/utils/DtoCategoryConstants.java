package com.example.emazonstock.application.utils;

public class DtoCategoryConstants {
    public static final String VALIDATION_NULL_DTO =
            "The value {0} cannot be null";
    public static final String VALIDATION_CATEGORY_EMPTY_OR_LONGER =
            "The category name cannot be empty or longer than 50 characters";
    public static final String VALIDATION_DESCRIPTION_EMPTY_OR_LONGER =
            "Description of category cannot be empty or longer than 70 characters";

    private DtoCategoryConstants() {
        throw new IllegalStateException("Utility class");
    }

}
