package org.example.clinica_backend.servicesimpls;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PacienteAlergiaServiceImpl implements PacienteAlergiaService {

    @Autowired private PacienteAlergiaRepository pacienteAlergiaRepository;
    @Autowired private PacienteRepository pacienteRepository;
    @Autowired private AlergiaRepository alergiaRepository;

    @Override
    public PacienteAlergiaDto createPacienteAlergia(PacienteAlergiaDto dto) {
        // valida FKs
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId()).orElseThrow(
                () -> new ResourceNotFoundException("Paciente not found with id " + dto.getPacienteId())
        );
        Alergia alergia = alergiaRepository.findById(dto.getAlergiaId()).orElseThrow(
                () -> new ResourceNotFoundException("Alergia not found with id " + dto.getAlergiaId())
        );

        // evita duplicados por la UK (paciente, alergia)
        boolean exists = pacienteAlergiaRepository
                .existsByPaciente_IdAndAlergia_Id(paciente.getId(), alergia.getId());
        if (exists) {
            throw new IllegalArgumentException("La asociación Paciente-Alergia ya existe");
        }

        // severidad por defecto si viene null/vacío
        String severidad = (dto.getSeveridad() == null || dto.getSeveridad().isBlank())
                ? "Leve" : dto.getSeveridad();

        PacienteAlergia pa = PacienteAlergiaMapper.mapPacienteAlergiaDTOToPacienteAlergia(dto);
        pa.setPaciente(paciente);
        pa.setAlergia(alergia);
        pa.setSeveridad(severidad);

        return PacienteAlergiaMapper.mapPacienteAlergiaToPacienteAlergiaDTO(
                pacienteAlergiaRepository.save(pa)
        );
    }

    @Override
    public PacienteAlergiaDto updatePacienteAlergia(Long id, PacienteAlergiaDto dto) {
        PacienteAlergia pa = pacienteAlergiaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PacienteAlergia not found with id " + id)
        );

        // Si cambian FKs, validamos y evitamos duplicados
        Long newPacienteId = (dto.getPacienteId() != null) ? dto.getPacienteId() : pa.getPaciente().getId();
        Long newAlergiaId  = (dto.getAlergiaId()  != null) ? dto.getAlergiaId()  : pa.getAlergia().getId();

        boolean pairChanged = !Objects.equals(newPacienteId, pa.getPaciente().getId()) ||
                !Objects.equals(newAlergiaId,  pa.getAlergia().getId());

        if (pairChanged) {
            boolean exists = pacienteAlergiaRepository
                    .existsByPaciente_IdAndAlergia_Id(newPacienteId, newAlergiaId);
            if (exists) throw new IllegalArgumentException("La asociación Paciente-Alergia ya existe");

            Paciente newPac = pacienteRepository.findById(newPacienteId).orElseThrow(
                    () -> new ResourceNotFoundException("Paciente not found with id " + newPacienteId)
            );
            Alergia newAle = alergiaRepository.findById(newAlergiaId).orElseThrow(
                    () -> new ResourceNotFoundException("Alergia not found with id " + newAlergiaId)
            );
            pa.setPaciente(newPac);
            pa.setAlergia(newAle);
        }

        if (dto.getSeveridad() != null && !dto.getSeveridad().isBlank()) {
            pa.setSeveridad(dto.getSeveridad());
        }

        return PacienteAlergiaMapper.mapPacienteAlergiaToPacienteAlergiaDTO(
                pacienteAlergiaRepository.save(pa)
        );
    }

    @Override
    public String deletePacienteAlergia(Long id) {
        PacienteAlergia pa = pacienteAlergiaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PacienteAlergia not found with id " + id)
        );
        pacienteAlergiaRepository.delete(pa);
        return "PacienteAlergia has been deleted";
    }

    @Override
    public PacienteAlergiaDto getPacienteAlergia(Long id) {
        PacienteAlergia pa = pacienteAlergiaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PacienteAlergia not found with id " + id)
        );
        return PacienteAlergiaMapper.mapPacienteAlergiaToPacienteAlergiaDTO(pa);
    }

    @Override
    public List<PacienteAlergiaDto> getPacienteAlergias() {
        return pacienteAlergiaRepository.findAll().stream()
                .map(PacienteAlergiaMapper::mapPacienteAlergiaToPacienteAlergiaDTO)
                .collect(Collectors.toList());
    }
}
