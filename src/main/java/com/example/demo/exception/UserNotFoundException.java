package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("Unable to find the user with id" +id);
    }
}
