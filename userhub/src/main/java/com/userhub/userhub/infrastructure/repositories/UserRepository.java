package com.userhub.userhub.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userhub.userhub.core.entities.user.User;

public interface UserRepository extends JpaRepository<User,String>{
    
}
