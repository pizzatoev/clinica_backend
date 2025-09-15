package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.ProcedimientoDto;
import org.example.clinica_backend.entities.Procedimiento;
import org.springframework.stereotype.Component;

@Component
public class ProcedimientoMapper {

    public ProcedimientoDto toDto(Procedimiento e) {
        if (e == null) return null;
        ProcedimientoDto dto = new ProcedimientoDto();
        dto.setId(e.getId());
        dto.setCodigo(e.getCodigo());
        dto.setDescripcion(e.getDescripcion());
        return dto;
    }

    public Procedimiento toEntity(ProcedimientoDto d) {
        if (d == null) return null;
        Procedimiento e = new Procedimiento();
        e.setId(d.getId()); // null al crear
        e.setCodigo(d.getCodigo());
        e.setDescripcion(d.getDescripcion());
        return e;
    }
}
