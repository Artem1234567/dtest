package com.webtest.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webtest.springboot.model.User;
import com.webtest.springboot.errors.UserAlreadyExistsException;
import com.webtest.springboot.service.UserRepository;

@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    UserRepository userService;

    @RequestMapping(value = "/userservice/register/{firstName}/{lastName}/{userName}/{password}", method = RequestMethod.GET)
    public ResponseEntity<Object> registerUser(@PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName,
            @PathVariable("userName") String userName,
            @PathVariable("password") String password) throws UserAlreadyExistsException {

        User user = new User(firstName, lastName, userName, password);
        /*
        if (userService.isUserExist(user)) {
            throw new UserAlreadyExistsException("A user with the given username already exists");
        }
        */
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
}
