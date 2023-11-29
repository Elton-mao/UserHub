package com.userhub.userhub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userhub.userhub.core.entities.user.User;
import com.userhub.userhub.core.usecases.UserUsecase;
import com.userhub.userhub.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController implements UserUsecase {
    @Autowired
    private UserService userService;

    
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id) {
        return this.userService.findUserById(id);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id) {
        return this.userService.deleteUserById(id);
    }

}
