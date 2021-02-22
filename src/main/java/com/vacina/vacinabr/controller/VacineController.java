package com.vacina.vacinabr.controller;

import com.vacina.vacinabr.model.Vacine;
import com.vacina.vacinabr.service.VacineService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/vacine")
public class VacineController {

    private final VacineService vacineService;

    public VacineController(VacineService vacineService) {
        this.vacineService = vacineService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void vacineStatus(@Valid @RequestBody Vacine vacine) {
        vacineService.createVacine(vacine);
    }
}
