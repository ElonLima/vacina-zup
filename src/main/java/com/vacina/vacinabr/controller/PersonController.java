package com.vacina.vacinabr.controller;

import com.vacina.vacinabr.model.Person;
import com.vacina.vacinabr.repository.PersonRepository;
import com.vacina.vacinabr.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    @Autowired
    public PersonController(PersonRepository personRepository,
                            PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRegistry (@Valid @RequestBody Person person) {
        personService.createPerson(person);
    }

}
