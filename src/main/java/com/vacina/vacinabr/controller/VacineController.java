package com.vacina.vacinabr.controller;

import com.vacina.vacinabr.dto.VacineDTO;
import com.vacina.vacinabr.exception.InvalidDataException;
import com.vacina.vacinabr.model.Vacine;
import com.vacina.vacinabr.service.VacineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/vacine")
public class VacineController {

    private final VacineService vacineService;

    @Autowired
    public VacineController(VacineService vacineService) {
        this.vacineService = vacineService;
    }

    @PostMapping
    public ResponseEntity<Vacine> vacineStatus(@Valid @RequestBody VacineDTO vacineDTO) throws InvalidDataException {
        return vacineService.createVacine(vacineDTO);
    }
}
