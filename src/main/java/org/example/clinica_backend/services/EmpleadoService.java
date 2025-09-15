package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.EmpleadoDto;
import java.util.List;

public interface EmpleadoService {
    List<EmpleadoDto> getAllEmpleados();
    EmpleadoDto getEmpleadoById(Long id);
    EmpleadoDto createEmpleado(EmpleadoDto dto);
    EmpleadoDto updateEmpleado(Long id, EmpleadoDto dto);
    void deleteEmpleado(Long id);
}
