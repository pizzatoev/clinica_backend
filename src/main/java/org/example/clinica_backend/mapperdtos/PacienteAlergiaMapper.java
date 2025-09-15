package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.PacienteAlergiaDto;
import org.example.clinica_backend.entities.PacienteAlergia;

public class PacienteAlergiaMapper {

    public static PacienteAlergiaDto mapPacienteAlergiaToPacienteAlergiaDTO(PacienteAlergia pa){
        return new PacienteAlergiaDto(
                pa.getId(),
                pa.getPaciente().getId(),
                pa.getAlergia().getId(),
                pa.getSeveridad()
        );
    }

    public static PacienteAlergia mapPacienteAlergiaDTOToPacienteAlergia(PacienteAlergiaDto dto){
        PacienteAlergia pa = new PacienteAlergia();
        pa.setId(dto.getId());
        pa.setSeveridad(dto.getSeveridad()); // las relaciones se setean en el Service
        return pa;
    }
}
