package com.vacina.vacinabr.service;

import com.vacina.vacinabr.dto.PersonDTO;
import com.vacina.vacinabr.exception.InvalidDataException;
import com.vacina.vacinabr.mapper.PersonMapper;
import com.vacina.vacinabr.model.Person;
import com.vacina.vacinabr.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResponseEntity<Person> createPerson(PersonDTO personDTO)
            throws InvalidDataException {

        ValidateData(personDTO.getEmail(), personDTO.getCpf());

        Person person = personMapper.toModel(personDTO);
        Person saved = personRepository.save(person);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    private void ValidateData(String email, String cpf) throws InvalidDataException {

        Optional<Person> emailOptional = personRepository
                .findByEmail(email);
        if (emailOptional.isPresent()){
            throw new InvalidDataException("Email inválido");
        }

        Optional<Person> cpfOptional = personRepository
                .findByCpf(cpf);
        if (cpfOptional.isPresent()){
            throw new InvalidDataException("CPF inválido");
        }
    }
}
