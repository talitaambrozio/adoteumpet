package com.br.adoteumpet.service;

import com.br.adoteumpet.AdoteumpetApplication;
import com.br.adoteumpet.dto.User.UserInputDto;
import com.br.adoteumpet.dto.User.UserOutputDto;
import com.br.adoteumpet.exceptions.ConflictException;
import com.br.adoteumpet.exceptions.InvalidRequestException;
import com.br.adoteumpet.model.User;
import com.br.adoteumpet.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository usuarioRepository;
    private static Logger logger = LoggerFactory.getLogger(AdoteumpetApplication.class);

    
    public UserService(UserRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}


	public UserOutputDto create(UserInputDto user){
        User newUser = UserInputDto.toEntity(user);
        validateUserInformation(newUser);
        usuarioRepository.save(newUser);
        logger.info("Salvando usuário no banco de dados.");
        logger.info("Usuário salvo com sucesso!");
        return new UserOutputDto(newUser);
    }

    private void validateUserInformation(User user){
                Boolean userAlreadyRegistered = usuarioRepository.existsByCpf(user.getCpf());
        if(userAlreadyRegistered){
            logger.info("Erro ao salvar usuário, já existe um usuário cadastrado com o cpf informado.");
            throw new ConflictException("There is already a registered user with this cpf.");
           
        }
        if(user.getCpf().length() > 11){
            logger.info("Erro ao salvar usuário, CPF excedeu máximo de caracteres.");
            throw new InvalidRequestException("Cpf must contain exactly 11 characters");
        }
        String cellPhone = user.getCellPhoneNumber();
        if(cellPhone.length() < 11 || cellPhone.length() > 13 ){
            logger.info("Erro ao salvar usuário, quantidade de caracteres de cellPhone incorreta.");
            throw new InvalidRequestException("CellPhoneNumber must contain between 11 and 13 characters");
        }
    }
}
