package com.userhub.userhub.core.entities.user;

import com.userhub.userhub.core.entities.address.Address;

public record UserDto(String name,String cpf,String password,String email,Address address ) {
    
}
