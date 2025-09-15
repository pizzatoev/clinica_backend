package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.EmpleadoDto;
import org.example.clinica_backend.entities.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    public EmpleadoDto toDto(Empleado e) {
        if (e == null) return null;
        EmpleadoDto dto = new EmpleadoDto();
        dto.setId(e.getId());
        dto.setNombres(e.getNombres());
        dto.setApellidos(e.getApellidos());
        dto.setEspecialidad(e.getEspecialidad());
        return dto;
    }

    public Empleado toEntity(EmpleadoDto d) {
        if (d == null) return null;
        Empleado e = new Empleado();
        e.setId(d.getId()); // suele ser null al crear
        e.setNombres(d.getNombres());
        e.setApellidos(d.getApellidos());
        e.setEspecialidad(d.getEspecialidad());
        return e;
    }
}
