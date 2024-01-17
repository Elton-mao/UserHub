package com.userhub.userhub.domain.entities;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
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

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="address_id")
    private Address address  = new Address();
        

    public User(String name, String cpf, String password, String email, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
        this.address = address ;
    }
}
