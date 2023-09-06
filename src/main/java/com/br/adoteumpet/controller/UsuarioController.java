package com.br.adoteumpet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.adoteumpet.dto.RegistroUsuarioDto;
import com.br.adoteumpet.dto.mapper.register.UserRegisterMapper;
import com.br.adoteumpet.model.User;
import com.br.adoteumpet.service.UserService;

@RestController
@RequestMapping(path = "/api/v1/usuarios")
public class UsuarioController {

    private final UserService usuarioService;
    
 
    public UsuarioController(UserService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}


	@PostMapping
    public ResponseEntity<String> salvar(@RequestBody RegistroUsuarioDto usuarioDto){
        User newUser = UserRegisterMapper.INSTANCE.dtoToEntity(usuarioDto);
        usuarioService.salvar(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
    }
}
