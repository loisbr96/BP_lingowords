package com.service.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public RestExceptionHandler(){
        super();
    }

    @ExceptionHandler(NoWordFoundException.class)
    protected ResponseEntity<Object> handleNotFound(Exception exception, WebRequest webRequest){
        return handleExceptionInternal(exception, "Word not found", new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }

}
