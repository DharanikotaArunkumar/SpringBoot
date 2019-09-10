package com.learnjava.springboot.rest.exceptionhandler;

import java.io.IOException;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity  constraintViolationException(Exception ex) throws IOException {
    	System.out.println(ex.toString());
       // response.sendError(HttpStatus.BAD_REQUEST.value());
        
        ResponseEntity responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

}