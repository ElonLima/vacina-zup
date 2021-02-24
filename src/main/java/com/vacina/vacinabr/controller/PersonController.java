package com.vacina.vacinabr.controller;

import com.vacina.vacinabr.dto.PersonDTO;
import com.vacina.vacinabr.exception.InvalidDataException;
import com.vacina.vacinabr.model.Person;
import com.vacina.vacinabr.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createRegistry
                                    (@RequestBody @Valid PersonDTO personDTO)
            throws InvalidDataException {
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPeople(){
        return personService.getAllPeople();
    }
}
