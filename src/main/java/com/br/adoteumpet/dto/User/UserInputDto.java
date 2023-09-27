package com.br.adoteumpet.dto.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInputDto{

        @NotBlank
        String name;
        @NotBlank
        String lastname;
        @NotBlank
        String email;
        @NotBlank
        @Size(min = 11, max = 13, message="must contain between 11 and 13 characters")
        String cellPhoneNumber;
        @NotBlank
        @Size(min = 11, max = 11, message="Size must be 11 characters")
        String cpf;
        
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
        public void setCpf(String cpf) {
                this.cpf = cpf;
        }

        
}
