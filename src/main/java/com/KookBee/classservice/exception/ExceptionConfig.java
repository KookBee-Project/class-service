package com.KookBee.classservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<String> loginException(LoginException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmailCheckException.class)
    public ResponseEntity<String> emailCheckException(EmailCheckException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DayOffDateCheckException.class)
    public ResponseEntity<String> DayOffDateCheckException(DayOffDateCheckException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DayOffUseDaysCheckException.class)
    public ResponseEntity<String> DayOffUseDaysCheckException(DayOffUseDaysCheckException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
