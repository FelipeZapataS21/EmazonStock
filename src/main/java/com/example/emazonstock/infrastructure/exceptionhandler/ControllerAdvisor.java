package com.example.emazonstock.infrastructure.exceptionhandler;

import static com.example.emazonstock.infrastructure.utils.InfrastructureConstants.*;
import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.ValueDoesNotExist;
import com.example.emazonstock.infrastructure.exception.CategoryAlreadyExist;
import com.example.emazonstock.infrastructure.exception.CategoryNotFound;
import com.example.emazonstock.infrastructure.exception.NoDataFoundException;
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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(CategoryAlreadyExist.class)
    public ResponseEntity<Map<String, String>> handleCategoryAlreadyExistsException(
            CategoryAlreadyExist categoryAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, EXCEPTION_CATEGORY_ALREADY_EXISTS));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, EXCEPTION_NO_DATA_FOUND));
    }

    @ExceptionHandler(CategoryNotFound.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFound(
            CategoryNotFound categoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, EXCEPTION_CATEGORY_NOT_FOUND));
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
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, EXCEPTION_VALUE_ALREADY_EXIST));
    }

}
