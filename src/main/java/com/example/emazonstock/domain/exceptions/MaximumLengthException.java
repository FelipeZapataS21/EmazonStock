package com.example.emazonstock.domain.exceptions;

public class MaximumLengthException extends RuntimeException{
    public MaximumLengthException(String message){
        super(message);
    }
}
