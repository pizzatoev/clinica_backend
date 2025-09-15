package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.AlergiaDto;
import org.example.clinica_backend.entities.Alergia;

import java.util.stream.Collectors;

public class AlergiaMapper {
    public static AlergiaDto mapAlergiaToAlergiaDTO(Alergia alergia){
        return new AlergiaDto(
                alergia.getId(),
                alergia.getNombre(),
                alergia.getDescripcion(),
                (alergia.getPacientes() == null) ? null :
                        alergia.getPacientes().stream()
                                .map(pa -> pa.getPaciente().getId())
                                .collect(Collectors.toSet())
        );
    }

    public static Alergia mapAlergiaDTOToAlergia(AlergiaDto alergiaDto){
        Alergia alergia = new Alergia();
        alergia.setId(alergiaDto.getId());
        alergia.setNombre(alergiaDto.getNombre());
        alergia.setDescripcion(alergiaDto.getDescripcion());
        return alergia;
    }
}

