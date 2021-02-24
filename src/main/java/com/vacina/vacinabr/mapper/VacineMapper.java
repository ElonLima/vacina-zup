package com.vacina.vacinabr.mapper;

import com.vacina.vacinabr.dto.VacineDTO;
import com.vacina.vacinabr.model.Vacine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VacineMapper {

    VacineMapper INSTANCE = Mappers.getMapper(VacineMapper.class);

    Vacine toModel(VacineDTO vacineDTO);

}
