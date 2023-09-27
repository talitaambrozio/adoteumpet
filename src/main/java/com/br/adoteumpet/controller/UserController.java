package com.br.adoteumpet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.adoteumpet.dto.User.UserInput;
import com.br.adoteumpet.dto.mapper.UserIO;
import com.br.adoteumpet.model.User;
import com.br.adoteumpet.service.UserService;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserIO userIO;
    
 
    public UserController(UserService userService, UserIO userIO) {
		super();
		this.userService = userService;
        this.userIO = userIO;
	}


	@PostMapping
    public ResponseEntity<String> save(@RequestBody UserInput dto){
        User newUser = userIO.mapTo(dto);
        userService.salvar(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
    }
}
