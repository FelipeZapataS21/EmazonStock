package com.example.emazonstock.domain.utils;

public final class DomainConstants{

    public static final String FIELD_ALREADY_DECLARED_VALUE = "This value already exists";
    public static final String FIELD_VALUE_DONT_EXIST = "This value don't exists";

    private DomainConstants() {
        throw new AssertionError("Cannot instantiate the class");
    }
}
