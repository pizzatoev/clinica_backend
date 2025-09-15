package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.DiagnosticoDto;
import org.example.clinica_backend.entities.Diagnostico;
import org.example.clinica_backend.entities.Encuentro;

public class DiagnosticoMapper {

    public static DiagnosticoDto mapToDiagnosticoDto(Diagnostico diagnostico) {
        return new DiagnosticoDto(
                diagnostico.getId(),
                diagnostico.getEncuentro().getId(),
                diagnostico.getCodigoCie10(),
                diagnostico.getDescripcion(),
                diagnostico.isPrincipal()
        );
    }

    public static Diagnostico mapToDiagnostico(DiagnosticoDto dto, Encuentro encuentro) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setId(dto.getId());
        diagnostico.setEncuentro(encuentro);
        diagnostico.setCodigoCie10(dto.getCodigoCie10());
        diagnostico.setDescripcion(dto.getDescripcion());
        diagnostico.setPrincipal(dto.isPrincipal());
        return diagnostico;
    }
}
