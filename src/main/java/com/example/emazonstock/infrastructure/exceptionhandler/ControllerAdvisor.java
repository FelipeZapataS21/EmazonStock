package com.example.emazonstock.infrastructure.exceptionhandler;

import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.NotValidValuePageSort;
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

import static com.example.emazonstock.infrastructure.utils.ControllerAdvisorConstants.*;

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

        String errorValue = errors.values().stream().findFirst().orElse(DEFAULT_VALUE_FOR_EXCEPTION);
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
                valueDoesNotExist.getMessage(),
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(exceptions, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyDeclaredValueException.class)
    public ResponseEntity<Exceptions> handleAlreadyDeclaredValueException(
            AlreadyDeclaredValueException alreadyDeclaredValueException) {
        Exceptions exceptions = new Exceptions(
                HttpStatus.CONFLICT.value(),
                alreadyDeclaredValueException.getMessage(),
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(exceptions, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotValidValuePageSort.class)
    public ResponseEntity<Exceptions> handleNotValidValue(
            NotValidValuePageSort notValidValuePageSort) {
        Exceptions exceptions = new Exceptions(
                HttpStatus.CONFLICT.value(),
                notValidValuePageSort.getMessage(),
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(exceptions, HttpStatus.CONFLICT);
    }

}
