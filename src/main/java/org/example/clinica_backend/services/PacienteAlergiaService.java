package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.PacienteAlergiaDto;

import java.util.List;

public interface PacienteAlergiaService {
    PacienteAlergiaDto createPacienteAlergia(PacienteAlergiaDto dto);
    PacienteAlergiaDto updatePacienteAlergia(Long id, PacienteAlergiaDto dto);
    String deletePacienteAlergia(Long id);
    PacienteAlergiaDto getPacienteAlergia(Long id);
    List<PacienteAlergiaDto> getPacienteAlergias();
}
