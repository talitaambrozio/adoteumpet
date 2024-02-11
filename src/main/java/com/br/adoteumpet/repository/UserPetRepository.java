package com.br.adoteumpet.repository;

import com.br.adoteumpet.model.User;
import com.br.adoteumpet.model.UserPet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserPetRepository extends JpaRepository<UserPet, UUID> {

}
