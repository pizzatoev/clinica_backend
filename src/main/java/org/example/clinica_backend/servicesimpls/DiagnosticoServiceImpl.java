package org.example.clinica_backend.services.impl;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.DiagnosticoDto;
import org.example.clinica_backend.entities.Diagnostico;
import org.example.clinica_backend.entities.Encuentro;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.DiagnosticoMapper;
import org.example.clinica_backend.repositories.DiagnosticoRepository;
import org.example.clinica_backend.repositories.EncuentroRepository;
import org.example.clinica_backend.services.DiagnosticoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DiagnosticoServiceImpl implements DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepository;
    private final EncuentroRepository encuentroRepository;

    @Override
    public List<DiagnosticoDto> getAllDiagnosticos() {
        return diagnosticoRepository.findAll()
                .stream()
                .map(DiagnosticoMapper::mapToDiagnosticoDto)
                .collect(Collectors.toList());
    }

    @Override
    public DiagnosticoDto getDiagnosticoById(Long id) {
        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diagnostico no encontrado con id: " + id));
        return DiagnosticoMapper.mapToDiagnosticoDto(diagnostico);
    }

    @Override
    public DiagnosticoDto createDiagnostico(DiagnosticoDto dto) {
        Encuentro encuentro = encuentroRepository.findById(dto.getEncuentroId())
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + dto.getEncuentroId()));
        Diagnostico diagnostico = DiagnosticoMapper.mapToDiagnostico(dto, encuentro);
        return DiagnosticoMapper.mapToDiagnosticoDto(diagnosticoRepository.save(diagnostico));
    }

    @Override
    public DiagnosticoDto updateDiagnostico(Long id, DiagnosticoDto dto) {
        Diagnostico existing = diagnosticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diagnostico no encontrado con id: " + id));

        Encuentro encuentro = encuentroRepository.findById(dto.getEncuentroId())
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + dto.getEncuentroId()));

        existing.setEncuentro(encuentro);
        existing.setCodigoCie10(dto.getCodigoCie10());
        existing.setDescripcion(dto.getDescripcion());
        existing.setPrincipal(dto.isPrincipal());

        return DiagnosticoMapper.mapToDiagnosticoDto(diagnosticoRepository.save(existing));
    }

    @Override
    public void deleteDiagnostico(Long id) {
        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diagnostico no encontrado con id: " + id));
        diagnosticoRepository.delete(diagnostico);
    }
}
