package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.EmpleadoDto;

import java.util.List;

public interface EmpleadoService {
    EmpleadoDto create(EmpleadoDto empleadoDto);
    EmpleadoDto update(Long id, EmpleadoDto empleadoDto);
    void delete(Long id);
    EmpleadoDto getById(Long id);
    List<EmpleadoDto> listAll();
}
