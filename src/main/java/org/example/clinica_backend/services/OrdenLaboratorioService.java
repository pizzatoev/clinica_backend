package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.OrdenLaboratorioDto;
import java.util.List;

public interface OrdenLaboratorioService {
    List<OrdenLaboratorioDto> getAllOrdenes();
    OrdenLaboratorioDto getOrdenById(Long id);
    OrdenLaboratorioDto createOrden(OrdenLaboratorioDto dto);
    OrdenLaboratorioDto updateOrden(Long id, OrdenLaboratorioDto dto);
    void deleteOrden(Long id);
}
