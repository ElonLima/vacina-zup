package com.vacina.vacinabr.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "email",
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
    )
    @Email(message = "E-mail inválido")
    private String email;

    @Column(
            name = "cpf",
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
    )
    @CPF(message = "CPF inválido")
    private String cpf;

    @Column(
            name = "date_of_birth",
            updatable = false,
            nullable = false
    )
    private Date birthDate;

    public Person() {
    }

    public Person(String name,
                  @Email(message = "E-mail inválido") String email,
                  @CPF(message = "CPF inválido") String cpf,
                  Date birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
