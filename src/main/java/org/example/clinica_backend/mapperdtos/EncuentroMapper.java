package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.EncuentroDto;
import org.example.clinica_backend.entities.Empleado;
import org.example.clinica_backend.entities.Encuentro;
import org.example.clinica_backend.entities.Paciente;

public class EncuentroMapper {

    public static EncuentroDto mapToEncuentroDto(Encuentro encuentro) {
        return new EncuentroDto(
                encuentro.getId(),
                encuentro.getPaciente().getId(),
                encuentro.getMedico().getId(),
                encuentro.getFecha(),
                encuentro.getTipo().name(),
                encuentro.getMotivo()
        );
    }

    public static Encuentro mapToEncuentro(EncuentroDto dto, Paciente paciente, Empleado medico) {
        Encuentro encuentro = new Encuentro();
        encuentro.setId(dto.getId());
        encuentro.setPaciente(paciente);
        encuentro.setMedico(medico);
        encuentro.setFecha(dto.getFecha());
        encuentro.setTipo(Encuentro.TipoEncuentro.valueOf(dto.getTipo()));
        encuentro.setMotivo(dto.getMotivo());
        return encuentro;
    }
}
