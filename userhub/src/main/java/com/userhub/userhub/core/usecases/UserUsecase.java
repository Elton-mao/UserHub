package com.userhub.userhub.core.usecases;

import org.springframework.http.ResponseEntity;
import com.userhub.userhub.core.entities.user.User;
import com.userhub.userhub.core.entities.user.UserDto;
/**
 * This interface defines the use cases related to user operations.
 */
public interface UserUsecase {
    //Saves a new user in the system.
    public ResponseEntity<UserDto> saveUser(UserDto user);
    //Retrieves a user by their unique identifier.
    public ResponseEntity<User> findUserById(String id);
    //Deletes a user by their unique identifier.
    public ResponseEntity<String> deleteUserById(String id);

}
