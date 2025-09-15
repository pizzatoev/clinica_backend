package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.DiagnosticoDto;
import java.util.List;

public interface DiagnosticoService {
    List<DiagnosticoDto> getAllDiagnosticos();
    DiagnosticoDto getDiagnosticoById(Long id);
    DiagnosticoDto createDiagnostico(DiagnosticoDto dto);
    DiagnosticoDto updateDiagnostico(Long id, DiagnosticoDto dto);
    void deleteDiagnostico(Long id);
}
