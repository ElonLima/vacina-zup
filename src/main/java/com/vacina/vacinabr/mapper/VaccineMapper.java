package com.vacina.vacinabr.mapper;

import com.vacina.vacinabr.dto.VaccineDTO;
import com.vacina.vacinabr.model.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VaccineMapper {

    VaccineMapper INSTANCE = Mappers.getMapper(VaccineMapper.class);

    Vaccine toModel(VaccineDTO vaccineDTO);

}
