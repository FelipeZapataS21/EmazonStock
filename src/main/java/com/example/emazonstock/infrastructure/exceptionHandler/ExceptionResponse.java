package com.example.emazonstock.infrastructure.exceptionHandler;

public enum ExceptionResponse {
    CATEGORY_NOT_FOUND("No Pokemon was found with that number"),
    CATEGORY_ALREADY_EXISTS("There is already a pokemon with that number"),
    NO_DATA_FOUND("No data found for the requested petition");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
