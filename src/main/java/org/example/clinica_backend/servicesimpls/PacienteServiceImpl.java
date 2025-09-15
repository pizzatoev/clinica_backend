package org.example.clinica_backend.servicesimpls;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.PacienteDto;
import org.example.clinica_backend.entities.Alergia;
import org.example.clinica_backend.entities.Paciente;
import org.example.clinica_backend.entities.PacienteAlergia;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.PacienteMapper;
import org.example.clinica_backend.repositories.AlergiaRepository;
import org.example.clinica_backend.repositories.PacienteAlergiaRepository;
import org.example.clinica_backend.repositories.PacienteRepository;
import org.example.clinica_backend.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private AlergiaRepository alergiaRepository;
    @Autowired
    private PacienteAlergiaRepository pacienteAlergiaRepository;

    @Override
    public PacienteDto createPaciente(PacienteDto pacienteDTO) {
        Paciente paciente = PacienteMapper.mapPacienteDTOToPaciente(pacienteDTO);

        paciente = pacienteRepository.save(paciente);

        if (pacienteDTO.getAlergiaIds() != null && !pacienteDTO.getAlergiaIds().isEmpty()) {
            Set<PacienteAlergia> enlaces = new LinkedHashSet<>();
            for (Long alergiaId : pacienteDTO.getAlergiaIds()) {
                Alergia alergia = alergiaRepository.findById(alergiaId).orElseThrow(
                        () -> new ResourceNotFoundException("Alergia not found with id " + alergiaId)
                );
                PacienteAlergia pa = new PacienteAlergia(
                        null,
                        paciente,
                        alergia,
                        "Leve"
                );
                pacienteAlergiaRepository.save(pa);
                enlaces.add(pa);
            }

            paciente.setAlergias(enlaces);
        }
        return PacienteMapper.mapPacienteToPacienteDTO(paciente);
    }

    @Override
    public PacienteDto updatePaciente(Long pacienteId, PacienteDto pacienteDTO) {

        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(
                () -> new ResourceNotFoundException("Paciente not found with id " + pacienteId)
        );

        paciente.setNombres(pacienteDTO.getNombres());
        paciente.setApellidos(pacienteDTO.getApellidos());
        paciente.setDocumento(pacienteDTO.getDocumento());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setSexo(pacienteDTO.getSexo());
        paciente.setGrupoSanguineo(pacienteDTO.getGrupoSanguineo());
        paciente.setAlergiasResumen(pacienteDTO.getAlergiasResumen());
        paciente = pacienteRepository.save(paciente);

        if (pacienteDTO.getAlergiaIds() != null) {
            List<PacienteAlergia> actuales = pacienteAlergiaRepository.findByPaciente_Id(pacienteId);

            Set<Long> actualesIds = actuales.stream()
                    .map(pa -> pa.getAlergia().getId())
                    .collect(Collectors.toSet());

            Set<Long> nuevosIds = new HashSet<>(pacienteDTO.getAlergiaIds());

            for (PacienteAlergia pa : actuales) {
                if (!nuevosIds.contains(pa.getAlergia().getId())) {
                    pacienteAlergiaRepository.delete(pa);
                }
            }

            for (Long alergiaId : nuevosIds) {
                if (!actualesIds.contains(alergiaId)) {
                    Alergia alergia = alergiaRepository.findById(alergiaId).orElseThrow(
                            () -> new ResourceNotFoundException("Alergia not found with id " + alergiaId)
                    );
                    PacienteAlergia pa = new PacienteAlergia(
                            null, paciente, alergia, "Leve"
                    );
                    pacienteAlergiaRepository.save(pa);
                }
            }

            paciente.setAlergias(new LinkedHashSet<>(
                    pacienteAlergiaRepository.findByPaciente_Id(pacienteId)
            ));
        }

        // 4) devolver DTO
        return PacienteMapper.mapPacienteToPacienteDTO(paciente);
    }

    @Override
    public String deletePaciente(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(
                () -> new ResourceNotFoundException("Paciente not found with id " + pacienteId)
        );
        pacienteRepository.delete(paciente);
        return "Paciente has been deleted";
    }

    @Override
    public PacienteDto getPaciente(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(
                () -> new ResourceNotFoundException("Paciente not found with id " + pacienteId)
        );
        paciente.setAlergias(new LinkedHashSet<>(
                pacienteAlergiaRepository.findByPaciente_Id(pacienteId)
        ));
        return PacienteMapper.mapPacienteToPacienteDTO(paciente);
    }

    @Override
    public List<PacienteDto> getPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(PacienteMapper::mapPacienteToPacienteDTO)
                .collect(Collectors.toList());
    }
}
