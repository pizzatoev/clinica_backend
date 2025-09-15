package org.example.clinica_backend.servicesimpls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.clinica_backend.dtos.EmpleadoDto;
import org.example.clinica_backend.entities.Empleado;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.EmpleadoMapper;
import org.example.clinica_backend.repositories.EmpleadoRepository;
import org.example.clinica_backend.services.EmpleadoService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper empleadoMapper; // ahora es la clase @Component

    @Override
    public EmpleadoDto create(EmpleadoDto dto) {
        Empleado entity = empleadoMapper.toEntity(dto);
        entity.setId(null);
        return empleadoMapper.toDto(empleadoRepository.save(entity));
    }

    @Override
    public EmpleadoDto update(Long id, EmpleadoDto dto) {
        Empleado e = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado: " + id));
        e.setNombres(dto.getNombres());
        e.setApellidos(dto.getApellidos());
        e.setEspecialidad(dto.getEspecialidad());
        return empleadoMapper.toDto(empleadoRepository.save(e));
    }

    @Override
    public void delete(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Empleado no encontrado: " + id);
        }
        empleadoRepository.deleteById(id);
    }

    @Override
    public EmpleadoDto getById(Long id) {
        return empleadoMapper.toDto(
                empleadoRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado: " + id))
        );
    }

    @Override
    public List<EmpleadoDto> listAll() {
        return empleadoRepository.findAll().stream().map(empleadoMapper::toDto).toList();
    }
}
