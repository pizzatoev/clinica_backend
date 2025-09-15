package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.PacienteAlergiaDto;
import java.util.List;

public interface PacienteAlergiaService {
    List<PacienteAlergiaDto> getAll();
    PacienteAlergiaDto getById(Long id);
    PacienteAlergiaDto create(PacienteAlergiaDto dto);
    PacienteAlergiaDto update(Long id, PacienteAlergiaDto dto);
    void delete(Long id);
}
