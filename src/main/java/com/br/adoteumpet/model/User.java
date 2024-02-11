package com.br.adoteumpet.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Pet> pets;


    public User(String name,String lastname,String email,String cellPhoneNumber,String cpf) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.cellPhoneNumber = cellPhoneNumber;
        this.cpf = cpf;
    }

}
