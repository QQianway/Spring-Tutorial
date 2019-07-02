package com.tutorialspoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = SpringException.class)
    public ResponseEntity<?> handleException(SpringException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getExceptionMsg());
    }
}