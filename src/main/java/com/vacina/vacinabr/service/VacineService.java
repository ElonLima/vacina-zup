package com.vacina.vacinabr.service;

import com.vacina.vacinabr.model.Vacine;
import com.vacina.vacinabr.repository.VacineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class VacineService {

    private final VacineRepository vacineRepository;

    public VacineService(VacineRepository vacineRepository) {
        this.vacineRepository = vacineRepository;
    }

    public ResponseEntity<Vacine> createVacine(@Valid Vacine vacine) {
        Vacine vacineCreated = vacineRepository.save(vacine);
        return new ResponseEntity<>(vacineCreated, HttpStatus.CREATED);
    }
}
