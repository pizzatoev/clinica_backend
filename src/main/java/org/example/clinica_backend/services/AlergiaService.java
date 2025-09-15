package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.AlergiaDto;
import java.util.List;

public interface AlergiaService {
    List<AlergiaDto> getAllAlergias();
    AlergiaDto getAlergiaById(Long id);
    AlergiaDto createAlergia(AlergiaDto dto);
    AlergiaDto updateAlergia(Long id, AlergiaDto dto);
    void deleteAlergia(Long id);
}
