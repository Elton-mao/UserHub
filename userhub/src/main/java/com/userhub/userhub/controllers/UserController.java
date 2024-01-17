package com.userhub.userhub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userhub.userhub.domain.entities.User;
import com.userhub.userhub.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService; 
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User newUser){
       return userService.saveUser(newUser); 
    }
}
