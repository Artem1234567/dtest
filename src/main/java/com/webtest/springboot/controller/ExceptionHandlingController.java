package com.webtest.springboot.controller;

import com.webtest.springboot.errors.ExceptionResponse;
import com.webtest.springboot.errors.UserAlreadyExistsException;
import com.webtest.springboot.errors.ResponseCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {
 
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> userAlreadyExists(UserAlreadyExistsException ex) {
        ExceptionResponse response = new ExceptionResponse(ResponseCodes.USER_ALREADY_EXISTS, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
