package com.home.takeaway.application.exception;

public class ValidationException extends Exception {

    public ValidationException(String message, Throwable err) {
        super(message, err);
    }
}
