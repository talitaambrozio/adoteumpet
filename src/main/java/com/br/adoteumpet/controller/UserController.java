package com.br.adoteumpet.controller;

import com.br.adoteumpet.dto.pet.PetInputDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.adoteumpet.dto.user.UserInputDto;
import com.br.adoteumpet.service.UserService;
import com.br.adoteumpet.dto.user.UserOutputDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
    public ResponseEntity<UserOutputDto> save(@RequestBody UserInputDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserOutputDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserOutputDto> findById(@PathVariable UUID userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserOutputDto> addPetToUser(@PathVariable UUID userId, @RequestBody PetInputDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.addPetToUser(userId, dto));
    }
}
