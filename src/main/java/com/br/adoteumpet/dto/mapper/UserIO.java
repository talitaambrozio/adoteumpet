
package com.br.adoteumpet.dto.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.br.adoteumpet.dto.User.UserInput;
import com.br.adoteumpet.model.User;

@Component
public class UserIO{


    private ModelMapper modelMapper;

    final Converter<UserInput, User> userConverter = new Converter<UserInput, User>() {

        @Override
        public User convert(MappingContext<UserInput, User> context) {
            UserInput userInput = context.getSource();
            // @formatter:off
            User user = new User();
            user.setName(userInput.name());
            user.setLastname(userInput.lastname());
            user.setEmail( userInput.email());
            user.setCellPhoneNumber(userInput.cellPhoneNumber());
            user.setCpf(userInput.cpf());
            // @formatter:on
            return user;
        }
    };

    public UserIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public User mapTo(UserInput userInput) {
        return this.modelMapper.map(userInput, User.class);
    }

}