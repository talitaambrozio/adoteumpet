
package com.br.adoteumpet.dto.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.br.adoteumpet.dto.User.UserInputDto;
import com.br.adoteumpet.model.User;

@Component
public class UserIOMapper{


    private ModelMapper modelMapper;

    final Converter<UserInputDto, User> userConverter = new Converter<UserInputDto, User>() {

        @Override
        public User convert(MappingContext<UserInputDto, User> context) {
            UserInputDto userInput = context.getSource();
            // @formatter:off
            User user = new User();
            user.setName(userInput.getName());
            user.setLastname(userInput.getLastname());
            user.setEmail( userInput.getEmail());
            user.setCellPhoneNumber(userInput.getCellPhoneNumber());
            user.setCpf(userInput.getCpf());
            // @formatter:on
            return user;
        }

    };

    

    public UserIOMapper() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public User mapToEntity(UserInputDto userInput) {
        return this.modelMapper.map(userInput, User.class);
    }

    public UserInputDto mapToDTO(User user){
        return this.modelMapper.map(user, UserInputDto.class);
    }

}