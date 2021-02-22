package com.vacina.vacinabr.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @SequenceGenerator(
            name = "personID_sequence",
            sequenceName = "personID_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "personID_sequence"
    )
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
    private String email;

    @Column(
            name = "cpf",
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
    )
    private String cpf;

    @Column(
            name = "date_of_birth",
            updatable = false,
            nullable = false
    )
    private Date birthDate;

    public Person(String name, String email, String cpf, Date birthDate) {
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
