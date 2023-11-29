package com.userhub.userhub.controllers;

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
    private UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id) {
        return this.userService.findUserById(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id) {
        return this.userService.deleteUserById(id);
    }

}
