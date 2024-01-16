package com.userhub.userhub.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userhub.userhub.domain.entities.address.Address;

public interface AddressRepository extends JpaRepository<Address,String>{
    
}
