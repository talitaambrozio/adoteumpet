package com.br.adoteumpet.service;

import com.br.adoteumpet.dto.User.UserOutputDto;
import com.br.adoteumpet.exceptions.NotFoundException;
import com.br.adoteumpet.model.User;
import com.br.adoteumpet.repository.UserRepository;
import com.br.adoteumpet.templates.UserTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    void shouldCreateAUser(){
        when(userRepository.save(any(User.class))).thenReturn(UserTemplate.user());

        UserOutputDto user = userService.create(UserTemplate.userInputDto());

        assertAll(
                () -> assertNotNull(user),
                () -> assertEquals(UserOutputDto.class, user.getClass()),
                () -> assertEquals(user.getLastname(), UserTemplate.userOutputDto().getLastname()),
                () -> assertEquals(user.getName(), UserTemplate.userOutputDto().getName()),
                () -> assertEquals(user.getEmail(), UserTemplate.userOutputDto().getEmail()),
                () -> assertEquals(user.getCellPhoneNumber(), UserTemplate.userOutputDto().getCellPhoneNumber())
        );
        verify(userRepository, times(1)).save(any(User.class));

    }
    @Test
    void shouldFindUserById(){
        when(userRepository.findById(any())).thenReturn(Optional.of(UserTemplate.user()));

        UserOutputDto user = userService.findUserById(UserTemplate.user().getUserId());

        assertAll(
                () -> assertNotNull(user),
                () -> assertEquals(UserOutputDto.class, user.getClass()),
                () -> assertEquals(user.getLastname(), UserTemplate.userOutputDto().getLastname()),
                () -> assertEquals(user.getName(), UserTemplate.userOutputDto().getName()),
                () -> assertEquals(user.getEmail(), UserTemplate.userOutputDto().getEmail()),
                () -> assertEquals(user.getCellPhoneNumber(), UserTemplate.userOutputDto().getCellPhoneNumber())
        );

        verify(userRepository, times(1)).findById(any());
    }

    @Test
    void itShouldThrowAnExceptionIfTheUserCannotBeFound(){
        when(userRepository.findById(any())).thenReturn(Optional.empty());

        try {
            userService.findUserById(UserTemplate.user().getUserId());
        }catch (Exception ex){
            assertAll(
                    () -> assertEquals(NotFoundException.class, ex.getClass()),
                    () -> assertEquals("Resource not found.", ex.getMessage())
            );
        }

    }

}
