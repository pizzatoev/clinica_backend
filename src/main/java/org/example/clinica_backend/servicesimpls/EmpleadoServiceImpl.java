package org.example.clinica_backend.servicesimpls;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.EmpleadoDto;
import org.example.clinica_backend.entities.Empleado;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.EmpleadoMapper;
import org.example.clinica_backend.repositories.EmpleadoRepository;
import org.example.clinica_backend.services.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoDto> getAllEmpleados() {
        return empleadoRepository.findAll()
                .stream()
                .map(EmpleadoMapper::mapToEmpleadoDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmpleadoDto getEmpleadoById(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con id: " + id));
        return EmpleadoMapper.mapToEmpleadoDto(empleado);
    }

    @Override
    public EmpleadoDto createEmpleado(EmpleadoDto dto) {
        Empleado empleado = EmpleadoMapper.mapToEmpleado(dto);
        return EmpleadoMapper.mapToEmpleadoDto(empleadoRepository.save(empleado));
    }

    @Override
    public EmpleadoDto updateEmpleado(Long id, EmpleadoDto dto) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con id: " + id));

        empleado.setNombres(dto.getNombres());
        empleado.setApellidos(dto.getApellidos());
        empleado.setEspecialidad(dto.getEspecialidad());

        return EmpleadoMapper.mapToEmpleadoDto(empleadoRepository.save(empleado));
    }

    @Override
    public void deleteEmpleado(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con id: " + id));
        empleadoRepository.delete(empleado);
    }
}
