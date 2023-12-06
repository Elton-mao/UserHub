package com.userhub.userhub.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.userhub.userhub.core.entities.user.User;
import com.userhub.userhub.core.entities.user.UserDto;
import com.userhub.userhub.core.usecases.UserUsecase;
import com.userhub.userhub.infrastructure.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService implements UserUsecase {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserDto> saveUser(UserDto data) {

        User newUser = new User(data.name(), data.cpf(), data.password(), data.email());
        UserDto newUserDto = new UserDto(newUser.getName(), newUser.getCpf(), newUser.getPassword(),
                newUser.getEmail());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().body(newUserDto);
    }

    public ResponseEntity<UserDto> findUserById(String id) {
        
        Optional<User> optinalUser = this.userRepository.findById(id);
        User user = optinalUser.orElseThrow(() -> new EntityNotFoundException(
                "Nonexistent Record: The provided ID may not exist in the database, possibly due to deletion or an incorrect ID. "));
                UserDto userDtoresponse = new UserDto(user.getName(),user.getCpf(), user.getEmail(),user.getPassword());
                return ResponseEntity.ok().body(userDtoresponse);

    }

    public ResponseEntity<String> deleteUserById(String id) {
        if (this.userRepository.existsById(id)) {
            this.userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(
                    "Nonexistent Record: The provided ID may not exist in the database, possibly due to deletion or an incorrect ID. ");
        }
        return ResponseEntity.ok().body("User deleted successfully");
    }

}
