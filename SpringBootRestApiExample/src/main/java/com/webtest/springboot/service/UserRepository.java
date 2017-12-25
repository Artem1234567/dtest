package com.webtest.springboot.service;

import com.webtest.springboot.errors.UserAlreadyExistsException;
import com.webtest.springboot.model.User;

public interface UserRepository {
    boolean isUserExist(User user);
    User createUser(User user) throws UserAlreadyExistsException;
}
