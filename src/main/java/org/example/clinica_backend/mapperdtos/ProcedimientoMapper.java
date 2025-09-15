package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.ProcedimientoDto;
import org.example.clinica_backend.entities.Procedimiento;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProcedimientoMapper {
    ProcedimientoDto toDto(Procedimiento e);
    Procedimiento toEntity(ProcedimientoDto d);
}