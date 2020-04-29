package com.service.exception;

public class NoWordFoundException extends RuntimeException {

    public NoWordFoundException(){
        super();
    }

    public NoWordFoundException(final String message, final Throwable cause){
        super(message,cause);
    }

    public NoWordFoundException(final String message){
        super(message);
    }

    public NoWordFoundException(final Throwable cause){
        super(cause);
    }
}
