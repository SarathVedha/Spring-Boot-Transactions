package com.vedha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GlobalExceptions {

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<Map<?,?>> handlePaymentException(PaymentException exception) {

        return ResponseEntity.badRequest().body(Map.of("errorMessage", exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<?,?>> handleException(Exception exception) {

        return ResponseEntity.badRequest().body(Map.of("errorMessage", exception.getMessage()));
    }

}
