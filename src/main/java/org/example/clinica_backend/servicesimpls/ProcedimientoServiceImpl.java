package org.example.clinica_backend.services.impl;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.ProcedimientoDto;
import org.example.clinica_backend.entities.Encuentro;
import org.example.clinica_backend.entities.Procedimiento;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.ProcedimientoMapper;
import org.example.clinica_backend.repositories.EncuentroRepository;
import org.example.clinica_backend.repositories.ProcedimientoRepository;
import org.example.clinica_backend.services.ProcedimientoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProcedimientoServiceImpl implements ProcedimientoService {

    private final ProcedimientoRepository procedimientoRepository;
    private final EncuentroRepository encuentroRepository;

    @Override
    public List<ProcedimientoDto> getAllProcedimientos() {
        return procedimientoRepository.findAll()
                .stream()
                .map(ProcedimientoMapper::mapToProcedimientoDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProcedimientoDto getProcedimientoById(Long id) {
        Procedimiento procedimiento = procedimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Procedimiento no encontrado con id: " + id));
        return ProcedimientoMapper.mapToProcedimientoDto(procedimiento);
    }

    @Override
    public ProcedimientoDto createProcedimiento(ProcedimientoDto dto) {
        Encuentro encuentro = encuentroRepository.findById(dto.getEncuentroId())
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + dto.getEncuentroId()));
        Procedimiento procedimiento = ProcedimientoMapper.mapToProcedimiento(dto, encuentro);
        return ProcedimientoMapper.mapToProcedimientoDto(procedimientoRepository.save(procedimiento));
    }

    @Override
    public ProcedimientoDto updateProcedimiento(Long id, ProcedimientoDto dto) {
        Procedimiento existing = procedimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Procedimiento no encontrado con id: " + id));

        Encuentro encuentro = encuentroRepository.findById(dto.getEncuentroId())
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + dto.getEncuentroId()));

        existing.setEncuentro(encuentro);
        existing.setCodigo(dto.getCodigo());
        existing.setDescripcion(dto.getDescripcion());

        return ProcedimientoMapper.mapToProcedimientoDto(procedimientoRepository.save(existing));
    }

    @Override
    public void deleteProcedimiento(Long id) {
        Procedimiento procedimiento = procedimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Procedimiento no encontrado con id: " + id));
        procedimientoRepository.delete(procedimiento);
    }
}
