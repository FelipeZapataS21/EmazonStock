package com.example.emazonstock.domain.utils.Constants;

public class ExceptionsConstants {

    public static final String EXCEPTION_NO_VALUE_FOUND =
            "No value found for the requested petition";
    public static final String EXCEPTION_VALUE_ALREADY_EXIST =
            "This value already exist";
    public static final String EXCEPTION_NOT_VALID_VALUE_PAGE_SORT =
            "Not valid value for sort attribute, must be 'asc' or 'desc'";

    private ExceptionsConstants() {
        throw new IllegalStateException("Utility class");
    }
}
