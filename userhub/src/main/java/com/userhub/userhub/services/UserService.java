package com.userhub.userhub.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.userhub.userhub.core.entities.user.User;
import com.userhub.userhub.core.usecases.UserUsecase;
import com.userhub.userhub.infrastructure.repositories.UserRepository;

public class UserService implements UserUsecase {
   
    @Autowired
    private UserRepository userRepository;

    
    public ResponseEntity<User> saveUser(User user) {
        this.userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    
    public ResponseEntity<User> findUserById(String id) {
        Optional<User> optinalUser = this.userRepository.findById(id);
        if (optinalUser.isEmpty()) {
            throw new NullPointerException("error");
        }
        User user = optinalUser.get();
        return ResponseEntity.ok().body(user);
    }

    
    public ResponseEntity<String> deleteUserById(String id) {
        this.userRepository.deleteById(id);
        return ResponseEntity.ok().body("Usuário deletado com Sucesso");
    }

}
