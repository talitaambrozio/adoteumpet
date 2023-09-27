
package com.br.adoteumpet.dto.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;
import com.br.adoteumpet.dto.User.UserOutputDto;
import com.br.adoteumpet.model.User;

@Component
public class UserOutputMapper{


    private ModelMapper modelMapper;

    final Converter<User, UserOutputDto> userConverter = new Converter<User, UserOutputDto>() {

        @Override
        public UserOutputDto convert(MappingContext<User, UserOutputDto> context) {
            User user = context.getSource();
            // @formatter:off
            UserOutputDto userOutputDto = new UserOutputDto();
            userOutputDto.setName(user.getName());
            userOutputDto.setLastname(user.getLastname());
            userOutputDto.setEmail( user.getEmail());
            userOutputDto.setCellPhoneNumber(user.getCellPhoneNumber());
            // @formatter:on
            return userOutputDto;
        }
    };

    public UserOutputMapper() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public UserOutputDto mapToDto(User user) {
        return this.modelMapper.map(user, UserOutputDto.class);
    }

}