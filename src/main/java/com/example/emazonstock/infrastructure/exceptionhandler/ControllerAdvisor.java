package com.example.emazonstock.infrastructure.exceptionhandler;

import static com.example.emazonstock.infrastructure.utils.ExceptionConstants.*;
import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.ValueDoesNotExist;
import com.example.emazonstock.domain.model.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Exceptions> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException) {

        Map<String, String> errors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        String errorValue = errors.values().stream().findFirst().orElse("Default Value");
        Exceptions exceptions = new Exceptions(
                HttpStatus.BAD_REQUEST.value(),
                errorValue,
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptions);
    }

    @ExceptionHandler(ValueDoesNotExist.class)
    public ResponseEntity<Exceptions> handleValueDoesNotExist(
            ValueDoesNotExist valueDoesNotExist) {
        Exceptions exceptions = new Exceptions(
                HttpStatus.BAD_REQUEST.value(),
                EXCEPTION_NO_VALUE_FOUND,
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(exceptions, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyDeclaredValueException.class)
    public ResponseEntity<Exceptions> handleAlreadyDeclaredValueException(
            AlreadyDeclaredValueException alreadyDeclaredValueException) {
        Exceptions exceptions = new Exceptions(
                HttpStatus.CONFLICT.value(),
                EXCEPTION_VALUE_ALREADY_EXIST,
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(exceptions, HttpStatus.CONFLICT);
    }

}
