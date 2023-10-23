package com.br.adoteumpet.dto.User;


import com.br.adoteumpet.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserOutputDto {


    String name;
    String lastname;
    String email;
    String cellPhoneNumber;

    public UserOutputDto(User user) {
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.cellPhoneNumber = user.getCellPhoneNumber();
    }

    public static List<UserOutputDto> listEntityToDto(List<User> userList) {
        return userList.stream().map(UserOutputDto::new).collect(Collectors.toList());
    }


}