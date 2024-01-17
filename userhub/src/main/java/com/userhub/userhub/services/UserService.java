package com.userhub.userhub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.userhub.userhub.domain.entities.User;
import com.userhub.userhub.infrastructure.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository uRepository ;
    
    public ResponseEntity<String> saveUser(User newUser){
        if ( newUser != null) {
            uRepository.save(newUser);    
            return ResponseEntity.ok().body("Usuário Salvo com Sucesso!");
        }
        else{
            return ResponseEntity.ok().body("Erro");
        }
        
    }
}
