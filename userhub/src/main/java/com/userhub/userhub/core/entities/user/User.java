package com.userhub.userhub.core.entities.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
    private String name;
    @NotBlank 
    private String cpf;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    public User(String name, String cpf, String password, String email) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
    }
}
