package com.vacina.vacinabr.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PersonDTO {

    private Long id;

    @NotNull @NotBlank
    private String name;

    @NotNull @NotBlank @Email
    private String email;

    @NotNull @NotBlank @CPF
    private String cpf;

    @NotNull
    private Date birthDate;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, String email, String cpf, Date birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
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

    public static PersonDTO.PersonDTOBuilder builder() {
        return new PersonDTO.PersonDTOBuilder();
    }
    public static class PersonDTOBuilder {

        private Long id;
        private String name;
        private String email;
        private String cpf;
        private Date birthDate;

        PersonDTOBuilder(){}

        public PersonDTOBuilder(Long id, String name, String email, String cpf, Date birthDate) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.cpf = cpf;
            this.birthDate = birthDate;
        }

        public PersonDTO.PersonDTOBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public PersonDTO.PersonDTOBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public PersonDTO.PersonDTOBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public PersonDTO.PersonDTOBuilder cpf(final String cpf) {
            this.cpf = cpf;
            return this;
        }

        public PersonDTO.PersonDTOBuilder birthDate(final Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public PersonDTO build(){
            return new PersonDTO(this.id, this.name, this.email, this.cpf, this.birthDate);
        }
    }
}
