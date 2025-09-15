package org.example.clinica_backend.services.impl;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.PacienteAlergiaDto;
import org.example.clinica_backend.entities.Alergia;
import org.example.clinica_backend.entities.Paciente;
import org.example.clinica_backend.entities.PacienteAlergia;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.PacienteAlergiaMapper;
import org.example.clinica_backend.repositories.AlergiaRepository;
import org.example.clinica_backend.repositories.PacienteAlergiaRepository;
import org.example.clinica_backend.repositories.PacienteRepository;
import org.example.clinica_backend.services.PacienteAlergiaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PacienteAlergiaServiceImpl implements PacienteAlergiaService {

    private final PacienteAlergiaRepository paRepository;
    private final PacienteRepository pacienteRepository;
    private final AlergiaRepository alergiaRepository;

    @Override
    public List<PacienteAlergiaDto> getAll() {
        return paRepository.findAll()
                .stream()
                .map(PacienteAlergiaMapper::mapToPacienteAlergiaDto)
                .collect(Collectors.toList());
    }

    @Override
    public PacienteAlergiaDto getById(Long id) {
        PacienteAlergia pa = paRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PacienteAlergia no encontrada con id: " + id));
        return PacienteAlergiaMapper.mapToPacienteAlergiaDto(pa);
    }

    @Override
    public PacienteAlergiaDto create(PacienteAlergiaDto dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + dto.getPacienteId()));
        Alergia alergia = alergiaRepository.findById(dto.getAlergiaId())
                .orElseThrow(() -> new ResourceNotFoundException("Alergia no encontrada con id: " + dto.getAlergiaId()));

        PacienteAlergia pa = PacienteAlergiaMapper.mapToPacienteAlergia(dto, paciente, alergia);
        return PacienteAlergiaMapper.mapToPacienteAlergiaDto(paRepository.save(pa));
    }

    @Override
    public PacienteAlergiaDto update(Long id, PacienteAlergiaDto dto) {
        PacienteAlergia pa = paRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PacienteAlergia no encontrada con id: " + id));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + dto.getPacienteId()));
        Alergia alergia = alergiaRepository.findById(dto.getAlergiaId())
                .orElseThrow(() -> new ResourceNotFoundException("Alergia no encontrada con id: " + dto.getAlergiaId()));

        pa.setPaciente(paciente);
        pa.setAlergia(alergia);
        pa.setSeveridad(dto.getSeveridad());

        return PacienteAlergiaMapper.mapToPacienteAlergiaDto(paRepository.save(pa));
    }

    @Override
    public void delete(Long id) {
        PacienteAlergia pa = paRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PacienteAlergia no encontrada con id: " + id));
        paRepository.delete(pa);
    }
}
