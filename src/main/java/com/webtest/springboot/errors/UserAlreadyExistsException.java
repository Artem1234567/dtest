package com.webtest.springboot.errors;

public class UserAlreadyExistsException extends RuntimeException {
 
    private final String resourceId;
 
    public UserAlreadyExistsException(String resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
}
