package org.example.clinica_backend.servicesimpls;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.AlergiaDto;
import org.example.clinica_backend.entities.Alergia;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.AlergiaMapper;
import org.example.clinica_backend.repositories.AlergiaRepository;
import org.example.clinica_backend.services.AlergiaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AlergiaServiceImpl implements AlergiaService {

    private final AlergiaRepository alergiaRepository;

    @Override
    public List<AlergiaDto> getAllAlergias() {
        return alergiaRepository.findAll()
                .stream()
                .map(AlergiaMapper::mapToAlergiaDto)
                .collect(Collectors.toList());
    }

    @Override
    public AlergiaDto getAlergiaById(Long id) {
        Alergia alergia = alergiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alergia no encontrada con id: " + id));
        return AlergiaMapper.mapToAlergiaDto(alergia);
    }

    @Override
    public AlergiaDto createAlergia(AlergiaDto dto) {
        Alergia alergia = AlergiaMapper.mapToAlergia(dto);
        return AlergiaMapper.mapToAlergiaDto(alergiaRepository.save(alergia));
    }

    @Override
    public AlergiaDto updateAlergia(Long id, AlergiaDto dto) {
        Alergia alergia = alergiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alergia no encontrada con id: " + id));

        alergia.setNombre(dto.getNombre());
        alergia.setDescripcion(dto.getDescripcion());

        return AlergiaMapper.mapToAlergiaDto(alergiaRepository.save(alergia));
    }

    @Override
    public void deleteAlergia(Long id) {
        Alergia alergia = alergiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alergia no encontrada con id: " + id));
        alergiaRepository.delete(alergia);
    }
}
