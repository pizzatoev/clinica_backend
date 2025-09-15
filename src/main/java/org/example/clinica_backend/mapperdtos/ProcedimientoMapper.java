package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.ProcedimientoDto;
import org.example.clinica_backend.entities.Encuentro;
import org.example.clinica_backend.entities.Procedimiento;

public class ProcedimientoMapper {

    public static ProcedimientoDto mapToProcedimientoDto(Procedimiento procedimiento) {
        return new ProcedimientoDto(
                procedimiento.getId(),
                procedimiento.getEncuentro().getId(),
                procedimiento.getCodigo(),
                procedimiento.getDescripcion()
        );
    }

    public static Procedimiento mapToProcedimiento(ProcedimientoDto dto, Encuentro encuentro) {
        Procedimiento procedimiento = new Procedimiento();
        procedimiento.setId(dto.getId());
        procedimiento.setEncuentro(encuentro);
        procedimiento.setCodigo(dto.getCodigo());
        procedimiento.setDescripcion(dto.getDescripcion());
        return procedimiento;
    }
}
