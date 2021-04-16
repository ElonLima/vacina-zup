package com.vacina.vacinabr.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "vaccine")
public class Vaccine {

    @Id
    @SequenceGenerator(
            name = "vaccine_sequence",
            sequenceName = "vaccine_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "vaccine_sequence"
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
            columnDefinition = "TEXT"
    )
    @Email
    private String email;

    @Column(
            name = "date",
            updatable = false,
            nullable = false
    )
    private Date date;

    public Vaccine(String name, String email, Date date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Vaccine() {

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
