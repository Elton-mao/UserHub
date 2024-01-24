package com.userhub.userhub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.userhub.userhub.domain.entities.Address;
import com.userhub.userhub.domain.entities.User;
import com.userhub.userhub.infrastructure.repositories.AddressRepository;
import com.userhub.userhub.infrastructure.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository uRepository ;
    @Autowired
    private AddressRepository aRepository;
    public ResponseEntity<String> saveUser(User newUser){
        if (newUser != null && newUser.getAddress() != null) {
            
            Address newAddress = newUser.getAddress();
            uRepository.save(newUser); 
            aRepository.save(newAddress);
            return ResponseEntity.ok().body("Usuário Salvo com Sucesso!");
        }
        else{
            return ResponseEntity.ok().body("Erro");
        }
        
    }
}
