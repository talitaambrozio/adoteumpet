package com.br.adoteumpet.dto.mapper.register;

import com.br.adoteumpet.dto.RegistroUsuarioDto;
import com.br.adoteumpet.dto.mapper.GenericMapper;
import com.br.adoteumpet.model.User;
import org.mapstruct.factory.Mappers;

public interface UserRegisterMapper extends GenericMapper<User, RegistroUsuarioDto> {

    UserRegisterMapper INSTANCE = Mappers.getMapper(UserRegisterMapper.class);
}
