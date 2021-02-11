package com.home.takeaway.application.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userId) {
        super("Пользователь не найден ID = " + userId);
    }
}
