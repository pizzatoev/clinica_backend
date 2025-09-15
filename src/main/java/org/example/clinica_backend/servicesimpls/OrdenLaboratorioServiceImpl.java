package org.example.clinica_backend.servicesimpls;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.OrdenLaboratorioDto;
import org.example.clinica_backend.entities.Encuentro;
import org.example.clinica_backend.entities.OrdenLaboratorio;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.OrdenLaboratorioMapper;
import org.example.clinica_backend.repositories.EncuentroRepository;
import org.example.clinica_backend.repositories.OrdenLaboratorioRepository;
import org.example.clinica_backend.services.OrdenLaboratorioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrdenLaboratorioServiceImpl implements OrdenLaboratorioService {

    private final OrdenLaboratorioRepository ordenRepository;
    private final EncuentroRepository encuentroRepository;

    @Override
    public List<OrdenLaboratorioDto> getAllOrdenes() {
        return ordenRepository.findAll()
                .stream()
                .map(OrdenLaboratorioMapper::mapToOrdenDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrdenLaboratorioDto getOrdenById(Long id) {
        OrdenLaboratorio orden = ordenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenLaboratorio no encontrada con id: " + id));
        return OrdenLaboratorioMapper.mapToOrdenDto(orden);
    }

    @Override
    public OrdenLaboratorioDto createOrden(OrdenLaboratorioDto dto) {
        Encuentro encuentro = encuentroRepository.findById(dto.getEncuentroId())
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + dto.getEncuentroId()));
        OrdenLaboratorio orden = OrdenLaboratorioMapper.mapToOrden(dto, encuentro);
        return OrdenLaboratorioMapper.mapToOrdenDto(ordenRepository.save(orden));
    }

    @Override
    public OrdenLaboratorioDto updateOrden(Long id, OrdenLaboratorioDto dto) {
        OrdenLaboratorio orden = ordenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenLaboratorio no encontrada con id: " + id));
        Encuentro encuentro = encuentroRepository.findById(dto.getEncuentroId())
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + dto.getEncuentroId()));

        orden.setEncuentro(encuentro);
        orden.setExamen(dto.getExamen());
        orden.setEstado(OrdenLaboratorio.EstadoOrden.valueOf(dto.getEstado()));

        return OrdenLaboratorioMapper.mapToOrdenDto(ordenRepository.save(orden));
    }

    @Override
    public void deleteOrden(Long id) {
        OrdenLaboratorio orden = ordenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenLaboratorio no encontrada con id: " + id));
        ordenRepository.delete(orden);
    }
}
