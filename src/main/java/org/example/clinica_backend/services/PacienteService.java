package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.PacienteDto;
import java.util.List;

public interface PacienteService {
    List<PacienteDto> getAllPacientes();
    PacienteDto getPacienteById(Long id);
    PacienteDto createPaciente(PacienteDto dto);
    PacienteDto updatePaciente(Long id, PacienteDto dto);
    void deletePaciente(Long id);
}
