package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.AlergiaDto;
import java.util.List;

public interface AlergiaService {
    AlergiaDto createAlergia(AlergiaDto alergiaDto);
    AlergiaDto updateAlergia(Long alergiaId, AlergiaDto alergiaDto);
    String deleteAlergia(Long alergiaId);
    AlergiaDto getAlergia(Long alergiaId);
    List<AlergiaDto> getAlergias();
}

