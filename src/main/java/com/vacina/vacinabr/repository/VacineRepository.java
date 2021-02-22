package com.vacina.vacinabr.repository;

import com.vacina.vacinabr.model.Vacine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacineRepository extends JpaRepository<Vacine, Long> {
    Optional<Vacine> findVacineByName(String name);
    Optional<Vacine> findVacineByEmail(String email);
}
