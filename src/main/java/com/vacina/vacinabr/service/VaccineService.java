package com.vacina.vacinabr.service;

import com.vacina.vacinabr.dto.VaccineDTO;
import com.vacina.vacinabr.exception.InvalidDataException;
import com.vacina.vacinabr.mapper.VaccineMapper;
import com.vacina.vacinabr.model.Vaccine;
import com.vacina.vacinabr.repository.VaccineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VaccineService {

    private final VaccineMapper vaccineMapper = VaccineMapper.INSTANCE;
    private final VaccineRepository vaccineRepository;

    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    public ResponseEntity<Vaccine> createVaccine(VaccineDTO vaccineDTO) throws InvalidDataException {

        ValidateData(vaccineDTO.getName(), vaccineDTO.getEmail(), vaccineDTO.getDate());

        Vaccine vaccine = vaccineMapper.toModel(vaccineDTO);

        vaccineRepository.save(vaccine);

        return new ResponseEntity<>(vaccine, HttpStatus.CREATED);
    }

    private void ValidateData(String name, String email, Date date) throws InvalidDataException {

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
