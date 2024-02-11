package com.br.adoteumpet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Table(name = "user_pet")
public class UserPet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userPetId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public UserPet(User user, Pet pet){
        this.user = user;
        this.pet = pet;
    }


}
