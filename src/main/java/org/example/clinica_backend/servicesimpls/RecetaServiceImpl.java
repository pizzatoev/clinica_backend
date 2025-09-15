package org.example.clinica_backend.servicesimpls;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.RecetaDto;
import org.example.clinica_backend.entities.Encuentro;
import org.example.clinica_backend.entities.Receta;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.RecetaMapper;
import org.example.clinica_backend.repositories.EncuentroRepository;
import org.example.clinica_backend.repositories.RecetaRepository;
import org.example.clinica_backend.services.RecetaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecetaServiceImpl implements RecetaService {

    private final RecetaRepository recetaRepository;
    private final EncuentroRepository encuentroRepository;

    @Override
    public List<RecetaDto> getAllRecetas() {
        return recetaRepository.findAll()
                .stream()
                .map(RecetaMapper::mapToRecetaDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecetaDto getRecetaById(Long id) {
        Receta receta = recetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receta no encontrada con id: " + id));
        return RecetaMapper.mapToRecetaDto(receta);
    }

    @Override
    public RecetaDto createReceta(RecetaDto dto) {
        Encuentro encuentro = encuentroRepository.findById(dto.getEncuentroId())
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + dto.getEncuentroId()));
        Receta receta = RecetaMapper.mapToReceta(dto, encuentro);
        return RecetaMapper.mapToRecetaDto(recetaRepository.save(receta));
    }

    @Override
    public RecetaDto updateReceta(Long id, RecetaDto dto) {
        Receta existing = recetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receta no encontrada con id: " + id));
        Encuentro encuentro = encuentroRepository.findById(dto.getEncuentroId())
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + dto.getEncuentroId()));

        existing.setEncuentro(encuentro);
        existing.setMedicamento(dto.getMedicamento());
        existing.setDosis(dto.getDosis());
        existing.setFrecuencia(dto.getFrecuencia());
        existing.setDuracionDias(dto.getDuracionDias());

        return RecetaMapper.mapToRecetaDto(recetaRepository.save(existing));
    }

    @Override
    public void deleteReceta(Long id) {
        Receta receta = recetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receta no encontrada con id: " + id));
        recetaRepository.delete(receta);
    }
}
