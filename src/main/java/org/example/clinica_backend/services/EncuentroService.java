package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.EncuentroDto;
import java.util.List;

public interface EncuentroService {
    List<EncuentroDto> getAllEncuentros();
    EncuentroDto getEncuentroById(Long id);
    EncuentroDto createEncuentro(EncuentroDto dto);
    EncuentroDto updateEncuentro(Long id, EncuentroDto dto);
    void deleteEncuentro(Long id);
}
