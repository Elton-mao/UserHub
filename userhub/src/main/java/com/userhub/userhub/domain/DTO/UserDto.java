package com.userhub.userhub.domain.DTO;

import com.userhub.userhub.domain.entities.Address;

public record UserDto(String name,String cpf,String password,String email,Address address ) {
    
}
