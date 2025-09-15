package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.OrdenLaboratorioDto;
import org.example.clinica_backend.entities.OrdenLaboratorio;
import org.example.clinica_backend.entities.Encuentro;

public class OrdenLaboratorioMapper {

    public static OrdenLaboratorioDto mapToOrdenDto(OrdenLaboratorio orden) {
        return new OrdenLaboratorioDto(
                orden.getId(),
                orden.getEncuentro().getId(),
                orden.getExamen(),
                orden.getEstado().name()
        );
    }

    public static OrdenLaboratorio mapToOrden(OrdenLaboratorioDto dto, Encuentro encuentro) {
        OrdenLaboratorio orden = new OrdenLaboratorio();
        orden.setId(dto.getId());
        orden.setEncuentro(encuentro);
        orden.setExamen(dto.getExamen());
        orden.setEstado(OrdenLaboratorio.EstadoOrden.valueOf(dto.getEstado()));
        return orden;
    }
}
