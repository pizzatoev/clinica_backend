package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.PacienteDto;
import org.example.clinica_backend.entities.Paciente;

public class PacienteMapper {

    public static PacienteDto mapToPacienteDto(Paciente paciente) {
        return new PacienteDto(
                paciente.getId(),
                paciente.getNombres(),
                paciente.getApellidos(),
                paciente.getDocumento(),
                paciente.getFechaNacimiento(),
                paciente.getSexo(),
                paciente.getGrupoSanguineo(),
                paciente.getAlergiasResumen()
        );
    }

    public static Paciente mapToPaciente(PacienteDto dto) {
        Paciente paciente = new Paciente();
        paciente.setId(dto.getId());
        paciente.setNombres(dto.getNombres());
        paciente.setApellidos(dto.getApellidos());
        paciente.setDocumento(dto.getDocumento());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setSexo(dto.getSexo());
        paciente.setGrupoSanguineo(dto.getGrupoSanguineo());
        paciente.setAlergiasResumen(dto.getAlergiasResumen());
        return paciente;
    }
}
