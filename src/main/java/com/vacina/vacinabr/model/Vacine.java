package com.vacina.vacinabr.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name = "vacine")
public class Vacine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Vacine(Long id, String name, @Email String email, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Vacine(String name, String email, Date date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Vacine() {

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
