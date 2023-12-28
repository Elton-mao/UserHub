package com.userhub.userhub.core.entities.user;

import org.hibernate.validator.constraints.br.CPF;

import com.userhub.userhub.core.entities.address.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank
    @Size(max = 40)
    private String name;
    @NotBlank 
    @Size(max = 40)
    @CPF
    private String cpf;
    @NotBlank
    @Size(max = 16)
    private String password;
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;
    
    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;
    

    public User(String name, String cpf, String password, String email) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
    }
}
