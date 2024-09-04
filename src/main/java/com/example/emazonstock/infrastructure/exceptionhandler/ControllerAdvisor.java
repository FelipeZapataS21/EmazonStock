package com.example.emazonstock.infrastructure.exceptionhandler;

import static com.example.emazonstock.infrastructure.utils.ExceptionConstants.*;
import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.ValueDoesNotExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
    }

    @ExceptionHandler(ValueDoesNotExist.class)
    public ResponseEntity<Map<String, String>> handleValueDoesNotExist(
            ValueDoesNotExist valueDoesNotExist) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, EXCEPTION_NO_VALUE_FOUND));
    }

    @ExceptionHandler(AlreadyDeclaredValueException.class)
    public ResponseEntity<Map<String, String>> handleAlreadyDeclaredValueException(
            AlreadyDeclaredValueException alreadyDeclaredValueException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, EXCEPTION_VALUE_ALREADY_EXIST));
    }

}
