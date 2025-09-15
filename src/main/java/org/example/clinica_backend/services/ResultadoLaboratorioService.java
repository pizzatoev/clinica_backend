package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.ResultadoLaboratorioDto;
import java.util.List;

public interface ResultadoLaboratorioService {
    List<ResultadoLaboratorioDto> getAllResultados();
    ResultadoLaboratorioDto getResultadoById(Long id);
    ResultadoLaboratorioDto createResultado(ResultadoLaboratorioDto dto);
    ResultadoLaboratorioDto updateResultado(Long id, ResultadoLaboratorioDto dto);
    void deleteResultado(Long id);
}
