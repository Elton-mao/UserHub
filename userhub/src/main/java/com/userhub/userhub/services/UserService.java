package com.userhub.userhub.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.userhub.userhub.core.entities.user.User;
import com.userhub.userhub.core.entities.user.UserDto;
import com.userhub.userhub.core.usecases.UserUsecase;
import com.userhub.userhub.infrastructure.repositories.UserRepository;

@Service
public class UserService implements UserUsecase {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserDto> saveUser(UserDto data) {
        User newUser = new User(data.name(), data.cpf(),data.password(),data.email());
        UserDto newUserDto = new UserDto(newUser.getName(), newUser.getCpf(), newUser.getPassword(),newUser.getEmail());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().body(newUserDto);
    }

    public ResponseEntity<User> findUserById(String id) {
        Optional<User> optinalUser = this.userRepository.findById(id);
        if (optinalUser.isEmpty()) {
            throw new NullPointerException("error teste");
        }
        User user = optinalUser.get();
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<String> deleteUserById(String id) {
        this.userRepository.deleteById(id);
        return ResponseEntity.ok().body("Usuário deletado com Sucesso");
    }

}
