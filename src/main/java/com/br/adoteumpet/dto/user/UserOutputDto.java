package com.br.adoteumpet.dto.user;


import com.br.adoteumpet.model.Pet;
import com.br.adoteumpet.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserOutputDto {


    UUID userId;
    String name;
    String lastname;
    String email;
    String cellPhoneNumber;
    List<Pet> pets;

    public UserOutputDto(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.cellPhoneNumber = user.getCellPhoneNumber();
        this.pets = user.getPets();
    }

    public static List<UserOutputDto> listEntityToDto(List<User> userList) {
        return userList.stream().map(UserOutputDto::new).collect(Collectors.toList());
    }


}