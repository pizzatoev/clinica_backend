package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.EmpleadoDto;
import org.example.clinica_backend.entities.Empleado;

public class EmpleadoMapper {

    public static EmpleadoDto mapToEmpleadoDto(Empleado empleado) {
        return new EmpleadoDto(
                empleado.getId(),
                empleado.getNombres(),
                empleado.getApellidos(),
                empleado.getEspecialidad()
        );
    }

    public static Empleado mapToEmpleado(EmpleadoDto dto) {
        Empleado empleado = new Empleado();
        empleado.setId(dto.getId());
        empleado.setNombres(dto.getNombres());
        empleado.setApellidos(dto.getApellidos());
        empleado.setEspecialidad(dto.getEspecialidad());
        return empleado;
    }
}
