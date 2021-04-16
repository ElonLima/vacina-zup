package com.vacina.vacinabr.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class VaccineDTO {

    @NotNull
    private String name;

    @NotNull
    private String email;

    private Date date;

    public VaccineDTO() {
    }


    public VaccineDTO(@NotNull String name,
                      @NotNull String email,
                      Date date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate() {
        return date;
    }

}
