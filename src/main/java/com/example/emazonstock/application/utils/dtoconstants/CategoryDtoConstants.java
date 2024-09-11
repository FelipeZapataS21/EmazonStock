package com.example.emazonstock.application.utils.dtoconstants;

public class CategoryDtoConstants {

    private CategoryDtoConstants(){throw new IllegalStateException("Utility Class");}

    public static final String VALIDATION_NULL_DTO_NAME_CATEGORY =
            "The value 'name' of 'category' cannot be null";
    public static final String VALIDATION_NULL_DTO_DESCRIPTION_CATEGORY =
            "The value 'description' of 'category' cannot be null";
    public static final String VALIDATION_CATEGORY_NAME_EMPTY_OR_LONGER =
            "The category name cannot be empty or longer than 50 characters";
    public static final String VALIDATION_CATEGORY_DESCRIPTION_EMPTY_OR_LONGER =
            "Description of category cannot be empty or longer than 70 characters";

}
