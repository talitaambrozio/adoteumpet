package com.br.adoteumpet.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String name;
    private String lastname;
    private String email;
    @Column(name = "cell_phone_number")
    private String cellPhoneNumber;
    private String cpf;
    @OneToMany
    private Set<Pet> pet;

    public User() {
    }

    public User(String name,String lastname,String email,String cellPhoneNumber,String cpf) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.cellPhoneNumber = cellPhoneNumber;
        this.cpf = cpf;
    }
    public User(UUID userId, String name,String lastname,String email,String cellPhoneNumber,String cpf) {
        this.userId = userId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.cellPhoneNumber = cellPhoneNumber;
        this.cpf = cpf;
    }
}
