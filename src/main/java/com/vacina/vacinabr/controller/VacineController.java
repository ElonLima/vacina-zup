package com.vacina.vacinabr.controller;

import com.vacina.vacinabr.dto.VacineDTO;
import com.vacina.vacinabr.exception.InvalidDataException;
import com.vacina.vacinabr.model.Vacine;
import com.vacina.vacinabr.service.VacineService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/vacine")
public class VacineController {

    private final VacineService vacineService;

    @Autowired
    public VacineController(VacineService vacineService) {
        this.vacineService = vacineService;
    }

    @ApiOperation(value = "This endpoint records information about vacines already taken in our database.")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @PostMapping
    public ResponseEntity<Vacine> vacineStatus(@Valid @RequestBody VacineDTO vacineDTO) throws InvalidDataException {
        return vacineService.createVacine(vacineDTO);
    }
}
