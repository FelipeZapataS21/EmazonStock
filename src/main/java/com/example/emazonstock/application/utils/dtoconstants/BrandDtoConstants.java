package com.example.emazonstock.application.utils.dtoconstants;

public class BrandDtoConstants {

    public static final String VALIDATION_NULL_DTO_NAME_BRAND =
            "The value 'name' of 'brand' cannot be null";
    public static final String VALIDATION_NULL_DTO_DESCRIPTION_BRAND =
            "The value 'description' of 'brand' cannot be null";
    public static final String VALIDATION_BRAND_NAME_EMPTY_OR_LONGER =
            "The brand name cannot be empty or longer than 50 characters";
    public static final String VALIDATION_BRAND_DESCRIPTION_EMPTY_OR_LONGER =
            "The brand description cannot be empty or longer than 120 characters";

    private BrandDtoConstants() {
        throw new IllegalStateException("Utility class");
    }
}
