package com.example.emazonstock.domain.exceptions;

public class ValueDoesNotExist extends RuntimeException {
    public ValueDoesNotExist(String message) {
        super(message);
    }
}
