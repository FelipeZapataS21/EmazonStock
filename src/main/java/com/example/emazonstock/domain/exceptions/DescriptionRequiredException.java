package com.example.emazonstock.domain.exceptions;

public class DescriptionRequiredException extends RuntimeException{
    public DescriptionRequiredException(String message){
        super(message);
    }
}
