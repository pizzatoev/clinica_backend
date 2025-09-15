package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.PacienteDto;

import java.util.List;

public interface PacienteService {
    PacienteDto createPaciente(PacienteDto pacienteDto);
    PacienteDto updatePaciente(Long pacienteId, PacienteDto pacienteDto);
    String deletePaciente(Long pacienteId);
    PacienteDto getPaciente(Long pacienteId);
    List<PacienteDto> getPacientes();
}

