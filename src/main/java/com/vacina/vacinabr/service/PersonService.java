package com.vacina.vacinabr.service;

import com.vacina.vacinabr.model.Person;
import com.vacina.vacinabr.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void createPerson(@Valid Person person) {
        Optional<Person> emailOptional = personRepository
                                            .findPersonByEmail(person.getEmail());
        if (emailOptional.isPresent()){
            throw new IllegalStateException("This email is already taken");
        }

        Optional<Person> cpfOptional = personRepository
                                        .findPersonByCpf(person.getCpf());
        if (cpfOptional.isPresent()){
            throw new IllegalStateException("This cpf is already taken");
        }

        personRepository.save(person);
    }
}
