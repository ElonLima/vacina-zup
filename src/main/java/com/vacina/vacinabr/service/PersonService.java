package com.vacina.vacinabr.service;

import com.vacina.vacinabr.model.Person;
import com.vacina.vacinabr.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResponseEntity<Person> createPerson(@Valid Person person) {
        Optional<Person> emailOptional = personRepository
                                            .findPersonByEmail(person.getEmail());
        if (emailOptional.isPresent()){
            return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
        }

        Optional<Person> cpfOptional = personRepository
                                        .findPersonByCpf(person.getCpf());
        if (cpfOptional.isPresent()){
            return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
        }

        personRepository.save(person);

        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
