package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.PacienteDto;
import org.example.clinica_backend.entities.Paciente;

import java.util.stream.Collectors;

public class PacienteMapper {

    public static PacienteDto mapPacienteToPacienteDTO(Paciente paciente){
        return new PacienteDto (
                paciente.getId(),
                paciente.getNombres(),
                paciente.getApellidos(),
                paciente.getDocumento(),
                paciente.getFechaNacimiento(),
                paciente.getSexo(),
                paciente.getGrupoSanguineo(),
                paciente.getAlergiasResumen(),
                (paciente.getAlergias() == null) ? null :
                        paciente.getAlergias().stream()
                                .map(pa -> pa.getAlergia().getId())
                                .collect(Collectors.toSet())
        );
    }

    public static Paciente mapPacienteDTOToPaciente(PacienteDto pacienteDTO){
        Paciente paciente = new Paciente();
        paciente.setId(pacienteDTO.getId());
        paciente.setNombres(pacienteDTO.getNombres());
        paciente.setApellidos(pacienteDTO.getApellidos());
        paciente.setDocumento(pacienteDTO.getDocumento());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setSexo(pacienteDTO.getSexo());
        paciente.setGrupoSanguineo(pacienteDTO.getGrupoSanguineo());
        paciente.setAlergiasResumen(pacienteDTO.getAlergiasResumen());
        return paciente;
    }
}
