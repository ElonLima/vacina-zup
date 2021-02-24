package com.vacina.vacinabr.mapper;

import com.vacina.vacinabr.dto.PersonDTO;
import com.vacina.vacinabr.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
