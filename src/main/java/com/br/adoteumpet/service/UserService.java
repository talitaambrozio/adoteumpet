package com.br.adoteumpet.service;

import com.br.adoteumpet.AdoteumpetApplication;
import com.br.adoteumpet.dto.pet.PetInputDto;
import com.br.adoteumpet.dto.user.UserInputDto;
import com.br.adoteumpet.dto.user.UserOutputDto;
import com.br.adoteumpet.exceptions.ConflictException;
import com.br.adoteumpet.exceptions.InvalidRequestException;
import com.br.adoteumpet.exceptions.NotFoundException;
import com.br.adoteumpet.model.Pet;
import com.br.adoteumpet.model.User;
import com.br.adoteumpet.model.UserPet;
import com.br.adoteumpet.repository.UserPetRepository;
import com.br.adoteumpet.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PetService petService;
    private final UserPetRepository userPetRepository;
    private static Logger logger = LoggerFactory.getLogger(AdoteumpetApplication.class);

    
    public UserService(UserRepository userRepository, PetService petService, UserPetRepository userPetRepository) {
		super();
		this.userRepository = userRepository;
        this.petService = petService;
        this.userPetRepository = userPetRepository;
    }


    @Transactional
	public UserOutputDto create(UserInputDto user){
        User newUser = UserInputDto.toEntity(user);
        validateUserInformation(newUser);
        userRepository.save(newUser);
        logger.info("Salvando usuário no banco de dados.");
        logger.info("Usuário salvo com sucesso!");
        return new UserOutputDto(newUser);
    }

    public UserOutputDto findUserById(UUID userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return new UserOutputDto(user.get());
        }
        throw new NotFoundException("Resource not found.");
    }

    public List<UserOutputDto> findAll(){
        List<User> users = userRepository.findAll();
        return UserOutputDto.listEntityToDto(users);
    }

    @Transactional
    public UserOutputDto addPetToUser(UUID userId, PetInputDto dto){
        User user = userRepository.findById(userId).orElseThrow(() ->new NotFoundException("Resource not found."));

        Pet pet = new Pet();
        pet.setUser(user);
        pet.setName(dto.getName());
        pet.setRace(dto.getRace());
        pet.setColor(dto.getColor());
        pet.setAge(dto.getAge());
        petService.save(pet);

        user.getPets().add(pet);
        userRepository.save(user);
        userPetRepository.save(new UserPet(user,pet));

        return new UserOutputDto(user);


    }

    private void validateUserInformation(User user){
                Boolean userAlreadyRegistered = userRepository.existsByCpf(user.getCpf());
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
