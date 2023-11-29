package com.userhub.userhub.core.usecases;

import org.springframework.http.ResponseEntity;
import com.userhub.userhub.core.entities.user.User;

public interface UserUsecase {

    public ResponseEntity<User> saveUser(User user);
    public ResponseEntity<User> findUserById(String id);
    public ResponseEntity<String> deleteUserById(String id);

}
