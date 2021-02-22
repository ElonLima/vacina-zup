package com.vacina.vacinabr.repository;

import com.vacina.vacinabr.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findPersonByEmail(String email);
    Optional<Person> findPersonByCpf(String cpf);
}
