package com.br.adoteumpet.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
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


    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getCpf() {
        return cpf;
    }


    public User(){

    }

    public User(UUID userId, String name, String lastname, String email, String cellPhoneNumber, String cpf){
        this.userId = userId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.cellPhoneNumber = cellPhoneNumber;
        this.cpf = cpf;
    }

}
