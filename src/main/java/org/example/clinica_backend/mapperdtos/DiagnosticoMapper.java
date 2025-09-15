package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.DiagnosticoDto;
import org.example.clinica_backend.entities.Diagnostico;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticoMapper {

    public DiagnosticoDto toDto(Diagnostico e) {
        if (e == null) return null;
        DiagnosticoDto dto = new DiagnosticoDto();
        dto.setId(e.getId());
        dto.setCodigoCie10(e.getCodigoCie10());
        dto.setDescripcion(e.getDescripcion());
        dto.setPrincipal(e.isPrincipal());
        return dto;
    }

    public Diagnostico toEntity(DiagnosticoDto d) {
        if (d == null) return null;
        Diagnostico e = new Diagnostico();
        e.setId(d.getId()); // suele venir null al crear
        e.setCodigoCie10(d.getCodigoCie10());
        e.setDescripcion(d.getDescripcion());
        e.setPrincipal(d.isPrincipal());
        return e;
    }
}
