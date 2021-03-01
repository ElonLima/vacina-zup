package com.vacina.vacinabr.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PersonDTO {

    @NotNull @NotBlank
    private String name;

    @NotNull @NotBlank
    @Email(message = "E-mail inválido")
    private String email;

    @NotNull @NotBlank
    @CPF @Length(max = 11)
    private String cpf;

    @NotNull
    private Date birthDate;

    public PersonDTO() {
    }

    public PersonDTO(@NotNull @NotBlank String name,
                     @NotNull @NotBlank @Email String email,
                     @NotNull @NotBlank @CPF String cpf,
                     @NotNull @NotBlank Date birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

}
