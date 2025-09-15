package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.*;
import org.example.clinica_backend.entities.Encuentro;
import org.example.clinica_backend.enums.TipoEncuentro;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { DiagnosticoMapper.class, ProcedimientoMapper.class })
public interface EncuentroMapper {

    // Entidad -> DTO: convierte tipo (String) -> TipoEncuentro
    @Mapping(source = "paciente.id", target = "pacienteId")
    @Mapping(source = "medico.id", target = "medicoId")
    @Mapping(source = "tipo", target = "tipo") // usa método stringToTipo abajo
    EncuentroDto toDto(Encuentro e);

    // CreateDto -> Entidad: convierte tipo (TipoEncuentro) -> String
    @Mapping(source = "pacienteId", target = "paciente.id")
    @Mapping(source = "medicoId", target = "medico.id")
    @Mapping(source = "tipo", target = "tipo") // usa método tipoToString abajo
    Encuentro toEntity(EncuentroCreateDto dto);

    // MapStruct usará estos helpers (métodos por defecto) para convertir
    default TipoEncuentro stringToTipo(String dbVal) {
        return dbVal == null ? null : TipoEncuentro.fromDb(dbVal);
    }

    default String tipoToString(TipoEncuentro tipo) {
        return tipo == null ? null : tipo.getDbValue();
    }
}
