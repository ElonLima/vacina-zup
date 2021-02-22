package com.vacina.vacinabr.service;

import com.vacina.vacinabr.model.Vacine;
import com.vacina.vacinabr.repository.VacineRepository;
import org.springframework.stereotype.Service;

@Service
public class VacineService {

    private final VacineRepository vacineRepository;

    public VacineService(VacineRepository vacineRepository) {
        this.vacineRepository = vacineRepository;
    }

    public void createVacine(Vacine vacine) {
        vacineRepository.save(vacine);
    }
}
