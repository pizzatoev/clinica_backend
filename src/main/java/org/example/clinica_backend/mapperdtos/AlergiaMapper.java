package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.AlergiaDto;
import org.example.clinica_backend.entities.Alergia;

public class AlergiaMapper {

    public static AlergiaDto mapToAlergiaDto(Alergia alergia) {
        return new AlergiaDto(
                alergia.getId(),
                alergia.getNombre(),
                alergia.getDescripcion()
        );
    }

    public static Alergia mapToAlergia(AlergiaDto dto) {
        Alergia alergia = new Alergia();
        alergia.setId(dto.getId());
        alergia.setNombre(dto.getNombre());
        alergia.setDescripcion(dto.getDescripcion());
        return alergia;
    }
}
