package org.example.clinica_backend.servicesimpls;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.PacienteDto;
import org.example.clinica_backend.entities.Paciente;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.PacienteMapper;
import org.example.clinica_backend.repositories.PacienteRepository;
import org.example.clinica_backend.services.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Override
    public List<PacienteDto> getAllPacientes() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::mapToPacienteDto)
                .collect(Collectors.toList());
    }

    @Override
    public PacienteDto getPacienteById(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + id));
        return PacienteMapper.mapToPacienteDto(paciente);
    }

    @Override
    public PacienteDto createPaciente(PacienteDto dto) {
        Paciente paciente = PacienteMapper.mapToPaciente(dto);
        return PacienteMapper.mapToPacienteDto(pacienteRepository.save(paciente));
    }

    @Override
    public PacienteDto updatePaciente(Long id, PacienteDto dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + id));

        paciente.setNombres(dto.getNombres());
        paciente.setApellidos(dto.getApellidos());
        paciente.setDocumento(dto.getDocumento());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setSexo(dto.getSexo());
        paciente.setGrupoSanguineo(dto.getGrupoSanguineo());
        paciente.setAlergiasResumen(dto.getAlergiasResumen());

        return PacienteMapper.mapToPacienteDto(pacienteRepository.save(paciente));
    }

    @Override
    public void deletePaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + id));
        pacienteRepository.delete(paciente);
    }
}
