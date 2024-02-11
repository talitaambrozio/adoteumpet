package com.br.adoteumpet.templates;

import com.br.adoteumpet.dto.user.UserInputDto;
import com.br.adoteumpet.dto.user.UserOutputDto;
import com.br.adoteumpet.model.Pet;
import com.br.adoteumpet.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserTemplate {

    public static UserOutputDto userOutputDto(){
        return new UserOutputDto(UserTemplate.user());
    }

    public static UserInputDto userInputDto(){
        return new UserInputDto(UserTemplate.user());
    }

    public static  User user(){
        UUID userId = UUID.fromString("e1198755-651e-4b08-855f-7e4ee147908d");
        List<Pet> pets = new ArrayList<>();
        return new User(
                userId,
                "Maria",
                "Silva",
                "ms@email.com",
                "15999994999",
                "44444444444",
                pets
                );
    }
}
