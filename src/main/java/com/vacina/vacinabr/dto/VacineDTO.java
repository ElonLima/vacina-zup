package com.vacina.vacinabr.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class VacineDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    private Date date;

    public VacineDTO() {
    }

    public VacineDTO(Long id, @NotNull String name, @NotNull String email, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public VacineDTO(@NotNull String name, @NotNull String email, Date date) {
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

    public static VacineDTO.VacineDTOBuilder builder(){
        return new VacineDTO.VacineDTOBuilder();
    }

    public static class VacineDTOBuilder {

        private Long id;
        private String name;
        private String email;
        private Date date;

        public VacineDTOBuilder() {
        }

        public VacineDTOBuilder(Long id, String name, String email, Date date) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.date = date;
        }

        public VacineDTO.VacineDTOBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public VacineDTO.VacineDTOBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public VacineDTO.VacineDTOBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public VacineDTO.VacineDTOBuilder date(final Date date) {
            this.date = date;
            return this;
        }

        public VacineDTO build(){
            return new VacineDTO(this.id, this.name,this.email,this.date);
        }
    }
}
