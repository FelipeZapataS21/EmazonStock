package com.example.emazonstock.infrastructure.utils;

public class ExceptionConstants {

    public static final String EXCEPTION_NO_VALUE_FOUND = "No value found for the requested petition";
    public static final String EXCEPTION_VALUE_ALREADY_EXIST = "This value already exist";

    private ExceptionConstants() {
        throw new IllegalStateException("Utility class");
    }
}
