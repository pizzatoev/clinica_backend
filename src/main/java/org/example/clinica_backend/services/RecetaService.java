package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.RecetaDto;
import java.util.List;

public interface RecetaService {
    List<RecetaDto> getAllRecetas();
    RecetaDto getRecetaById(Long id);
    RecetaDto createReceta(RecetaDto dto);
    RecetaDto updateReceta(Long id, RecetaDto dto);
    void deleteReceta(Long id);
}
