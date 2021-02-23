package com.vacina.vacinabr.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name = "vacine")
public class Vacine {

    public Vacine(String name, String email, Date date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Vacine() {

    }

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
}
