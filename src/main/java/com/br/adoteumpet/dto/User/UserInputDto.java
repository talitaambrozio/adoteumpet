package com.br.adoteumpet.dto.User;

import com.br.adoteumpet.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserInputDto {

    @NotBlank
    String name;
    @NotBlank
    String lastname;
    @NotBlank
    String email;
    @NotBlank
    @Size(min = 11, max = 13, message = "must contain between 11 and 13 characters")
    String cellPhoneNumber;
    @NotBlank
    @Size(min = 11, max = 11, message = "Size must be 11 characters")
    String cpf;

    public UserInputDto(User user) {
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.cellPhoneNumber = user.getCellPhoneNumber();
        this.cpf = user.getCpf();
    }

    public static List<UserInputDto> listEntityToDto(List<User> userList) {
        return userList.stream().map(UserInputDto::new).collect(Collectors.toList());
    }
    public static User toEntity(UserInputDto userInput){
            return new User(
                    userInput.name,
                    userInput.lastname,
                    userInput.email,
                    userInput.cellPhoneNumber,
                    userInput.cpf);
    }

}

