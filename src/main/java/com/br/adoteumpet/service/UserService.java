package com.br.adoteumpet.service;

import com.br.adoteumpet.AdoteumpetApplication;
import com.br.adoteumpet.model.User;
import com.br.adoteumpet.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository usuarioRepository;
    private static Logger logger = LoggerFactory.getLogger(AdoteumpetApplication.class);

    public void salvar(User user){
        usuarioRepository.save(user);
        logger.info("Salvando usuário no banco de dados.");
        logger.info("Usuário salvo com sucesso!");
    }
}
