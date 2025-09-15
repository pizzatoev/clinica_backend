package org.example.clinica_backend.servicesimpls;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.EncuentroDto;
import org.example.clinica_backend.entities.Encuentro;
import org.example.clinica_backend.entities.Paciente;
import org.example.clinica_backend.entities.Empleado;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.EncuentroMapper;
import org.example.clinica_backend.repositories.EncuentroRepository;
import org.example.clinica_backend.repositories.PacienteRepository;
import org.example.clinica_backend.repositories.EmpleadoRepository;
import org.example.clinica_backend.services.EncuentroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EncuentroServiceImpl implements EncuentroService {

    private final EncuentroRepository encuentroRepository;
    private final PacienteRepository pacienteRepository;
    private final EmpleadoRepository empleadoRepository;

    @Override
    public List<EncuentroDto> getAllEncuentros() {
        return encuentroRepository.findAll()
                .stream()
                .map(EncuentroMapper::mapToEncuentroDto)
                .collect(Collectors.toList());
    }

    @Override
    public EncuentroDto getEncuentroById(Long id) {
        Encuentro encuentro = encuentroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + id));
        return EncuentroMapper.mapToEncuentroDto(encuentro);
    }

    @Override
    public EncuentroDto createEncuentro(EncuentroDto dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + dto.getPacienteId()));
        Empleado medico = empleadoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con id: " + dto.getMedicoId()));

        Encuentro encuentro = EncuentroMapper.mapToEncuentro(dto, paciente, medico);
        return EncuentroMapper.mapToEncuentroDto(encuentroRepository.save(encuentro));
    }

    @Override
    public EncuentroDto updateEncuentro(Long id, EncuentroDto dto) {
        Encuentro existing = encuentroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + id));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + dto.getPacienteId()));
        Empleado medico = empleadoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con id: " + dto.getMedicoId()));

        existing.setPaciente(paciente);
        existing.setMedico(medico);
        existing.setFecha(dto.getFecha());
        existing.setTipo(Encuentro.TipoEncuentro.valueOf(dto.getTipo()));
        existing.setMotivo(dto.getMotivo());

        return EncuentroMapper.mapToEncuentroDto(encuentroRepository.save(existing));
    }

    @Override
    public void deleteEncuentro(Long id) {
        Encuentro encuentro = encuentroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Encuentro no encontrado con id: " + id));
        encuentroRepository.delete(encuentro);
    }
}
