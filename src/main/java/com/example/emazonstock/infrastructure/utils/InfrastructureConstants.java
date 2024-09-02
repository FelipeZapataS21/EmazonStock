package com.example.emazonstock.infrastructure.utils;

public class InfrastructureConstants {

    private InfrastructureConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String EXCEPTION_CATEGORY_NOT_FOUND = "No Category was found with that name";
    public static final String EXCEPTION_CATEGORY_ALREADY_EXISTS = "There is already a category with that name";
    public static final String EXCEPTION_NO_DATA_FOUND = "No data found for the requested petition";
    public static final String EXCEPTION_NO_VALUE_FOUND = "No value found for the requested petition";
    public static final String EXCEPTION_VALUE_ALREADY_EXIST = "This value already exist";
}
