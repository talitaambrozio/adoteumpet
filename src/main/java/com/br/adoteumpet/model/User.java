package com.br.adoteumpet.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@EqualsAndHashCode
@ToString
@Builder
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String name;
    private String lastname;
    private String email;
    private String cellPhoneNumber;
    private String cpf;

}
