package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.PacienteAlergiaDto;
import org.example.clinica_backend.entities.Alergia;
import org.example.clinica_backend.entities.Paciente;
import org.example.clinica_backend.entities.PacienteAlergia;

public class PacienteAlergiaMapper {

    public static PacienteAlergiaDto mapToPacienteAlergiaDto(PacienteAlergia pa) {
        return new PacienteAlergiaDto(
                pa.getId(),
                pa.getPaciente().getId(),
                pa.getAlergia().getId(),
                pa.getSeveridad()
        );
    }

    public static PacienteAlergia mapToPacienteAlergia(PacienteAlergiaDto dto, Paciente paciente, Alergia alergia) {
        PacienteAlergia pa = new PacienteAlergia();
        pa.setId(dto.getId());
        pa.setPaciente(paciente);
        pa.setAlergia(alergia);
        pa.setSeveridad(dto.getSeveridad());
        return pa;
    }
}
