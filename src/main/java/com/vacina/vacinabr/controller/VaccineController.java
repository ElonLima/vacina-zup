package com.vacina.vacinabr.controller;

import com.vacina.vacinabr.dto.VaccineDTO;
import com.vacina.vacinabr.exception.InvalidDataException;
import com.vacina.vacinabr.model.Vaccine;
import com.vacina.vacinabr.service.VaccineService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/vaccine")
public class VaccineController {

    private final VaccineService vaccineService;

    @Autowired
    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @ApiOperation(value = "This endpoint records information about vaccines already taken in our database.")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @PostMapping
    public ResponseEntity<Vaccine> vaccineStatus(@Valid @RequestBody VaccineDTO vaccineDTO) throws InvalidDataException {
        return vaccineService.createVaccine(vaccineDTO);
    }
}
