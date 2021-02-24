package com.vacina.vacinabr.service;

import com.vacina.vacinabr.dto.VacineDTO;
import com.vacina.vacinabr.exception.InvalidDataException;
import com.vacina.vacinabr.mapper.VacineMapper;
import com.vacina.vacinabr.model.Vacine;
import com.vacina.vacinabr.repository.VacineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VacineService {

    private final VacineMapper vacineMapper = VacineMapper.INSTANCE;
    private final VacineRepository vacineRepository;

    public VacineService(VacineRepository vacineRepository) {
        this.vacineRepository = vacineRepository;
    }

    public ResponseEntity<Vacine> createVacine(VacineDTO vacineDTO) throws InvalidDataException {

        ValidadeData(vacineDTO.getName(),vacineDTO.getEmail(), vacineDTO.getDate());

        Vacine vacine = vacineMapper.toModel(vacineDTO);

        vacineRepository.save(vacine);

        return new ResponseEntity<>(vacine, HttpStatus.CREATED);
    }

    private void ValidadeData(String name, String email, Date date) throws InvalidDataException {

        if (name.equals("")){
            throw new InvalidDataException("O nome está nulo ou vazio.");
        }
        if (email.equals("")){
            throw new InvalidDataException("O email está nulo ou vazio.");
        }
        if (date == null){
            throw new InvalidDataException("A data está nulo ou vazio.");
        }
    }

}
