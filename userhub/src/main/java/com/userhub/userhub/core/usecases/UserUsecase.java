package com.userhub.userhub.core.usecases;

import org.springframework.http.ResponseEntity;
import com.userhub.userhub.core.entities.user.User;
/**
 * This interface defines the use cases related to user operations.
 */
public interface UserUsecase {
    //Saves a new user in the system.
    public ResponseEntity<User> saveUser(User user);
    //Retrieves a user by their unique identifier.
    public ResponseEntity<User> findUserById(String id);
    //Deletes a user by their unique identifier.
    public ResponseEntity<String> deleteUserById(String id);

}
