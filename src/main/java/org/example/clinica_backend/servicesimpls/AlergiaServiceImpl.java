package org.example.clinica_backend.servicesimpls;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.AlergiaDto;
import org.example.clinica_backend.entities.Alergia;
import org.example.clinica_backend.entities.Paciente;
import org.example.clinica_backend.entities.PacienteAlergia;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.AlergiaMapper;
import org.example.clinica_backend.repositories.AlergiaRepository;
import org.example.clinica_backend.repositories.PacienteAlergiaRepository;
import org.example.clinica_backend.repositories.PacienteRepository;
import org.example.clinica_backend.services.AlergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AlergiaServiceImpl implements AlergiaService {

    @Autowired private AlergiaRepository alergiaRepository;
    @Autowired private PacienteRepository pacienteRepository;
    @Autowired private PacienteAlergiaRepository pacienteAlergiaRepository;

    @Override
    public AlergiaDto createAlergia(AlergiaDto alergiaDto) {
        Alergia alergia = AlergiaMapper.mapAlergiaDTOToAlergia(alergiaDto);
        alergia = alergiaRepository.save(alergia);

        if (alergiaDto.getPacienteIds() != null && !alergiaDto.getPacienteIds().isEmpty()) {
            Set<PacienteAlergia> enlaces = new LinkedHashSet<>();
            for (Long pacienteId : alergiaDto.getPacienteIds()) {
                Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(
                        () -> new ResourceNotFoundException("Paciente not found with id " + pacienteId)
                );
                PacienteAlergia pa = new PacienteAlergia(null, paciente, alergia, "Leve");
                pacienteAlergiaRepository.save(pa);
                enlaces.add(pa);
            }
            alergia.setPacientes(enlaces);
        }

        return AlergiaMapper.mapAlergiaToAlergiaDTO(alergia);
    }

    @Override
    public AlergiaDto updateAlergia(Long alergiaId, AlergiaDto alergiaDto) {
        Alergia alergia = alergiaRepository.findById(alergiaId).orElseThrow(
                () -> new ResourceNotFoundException("Alergia not found with id " + alergiaId)
        );

        alergia.setNombre(alergiaDto.getNombre());
        alergia.setDescripcion(alergiaDto.getDescripcion());
        alergia = alergiaRepository.save(alergia);

        if (alergiaDto.getPacienteIds() != null) {
            List<PacienteAlergia> actuales = pacienteAlergiaRepository.findByAlergiaId(alergiaId);


            Set<Long> actualesIds = actuales.stream()
                    .map(pa -> pa.getPaciente().getId())
                    .collect(Collectors.toSet());

            Set<Long> nuevosIds = new HashSet<>(alergiaDto.getPacienteIds());

            for (PacienteAlergia pa : actuales) {
                if (!nuevosIds.contains(pa.getPaciente().getId())) {
                    pacienteAlergiaRepository.delete(pa);
                }
            }

            for (Long pacienteId : nuevosIds) {
                if (!actualesIds.contains(pacienteId)) {
                    Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(
                            () -> new ResourceNotFoundException("Paciente not found with id " + pacienteId)
                    );
                    pacienteAlergiaRepository.save(new PacienteAlergia(null, paciente, alergia, "Leve"));
                }
            }

            alergia.setPacientes(new LinkedHashSet<>(
                    pacienteAlergiaRepository.findByAlergiaId(alergiaId)
            ));
        }

        return AlergiaMapper.mapAlergiaToAlergiaDTO(alergia);
    }

    @Override
    public String deleteAlergia(Long alergiaId) {
        Alergia alergia = alergiaRepository.findById(alergiaId).orElseThrow(
                () -> new ResourceNotFoundException("Alergia not found with id " + alergiaId)
        );
        alergiaRepository.delete(alergia);
        return "Alergia has been deleted";
    }

    @Override
    public AlergiaDto getAlergia(Long alergiaId) {
        Alergia alergia = alergiaRepository.findById(alergiaId).orElseThrow(
                () -> new ResourceNotFoundException("Alergia not found with id " + alergiaId)
        );
        alergia.setPacientes(new LinkedHashSet<>(
                pacienteAlergiaRepository.findByAlergiaId(alergiaId)
        ));
        return AlergiaMapper.mapAlergiaToAlergiaDTO(alergia);
    }

    @Override
    public List<AlergiaDto> getAlergias() {
        return alergiaRepository.findAll().stream()
                .map(AlergiaMapper::mapAlergiaToAlergiaDTO)
                .collect(Collectors.toList());
    }
}
