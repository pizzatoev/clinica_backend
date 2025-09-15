package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.DiagnosticoDto;
import org.example.clinica_backend.entities.Diagnostico;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DiagnosticoMapper {
    DiagnosticoDto toDto(Diagnostico e);
    Diagnostico toEntity(DiagnosticoDto d);
}
