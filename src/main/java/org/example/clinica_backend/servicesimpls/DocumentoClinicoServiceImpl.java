package org.example.clinica_backend.servicesimpls;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.DocumentoClinicoDto;
import org.example.clinica_backend.entities.DocumentoClinico;
import org.example.clinica_backend.entities.Paciente;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.DocumentoClinicoMapper;
import org.example.clinica_backend.repositories.DocumentoClinicoRepository;
import org.example.clinica_backend.repositories.PacienteRepository;
import org.example.clinica_backend.services.DocumentoClinicoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DocumentoClinicoServiceImpl implements DocumentoClinicoService {

    private final DocumentoClinicoRepository documentoRepository;
    private final PacienteRepository pacienteRepository;

    @Override
    public List<DocumentoClinicoDto> getAllDocumentos() {
        return documentoRepository.findAll()
                .stream()
                .map(DocumentoClinicoMapper::mapToDocumentoDto)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentoClinicoDto getDocumentoById(Long id) {
        DocumentoClinico doc = documentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DocumentoClinico no encontrado con id: " + id));
        return DocumentoClinicoMapper.mapToDocumentoDto(doc);
    }

    @Override
    public DocumentoClinicoDto createDocumento(DocumentoClinicoDto dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + dto.getPacienteId()));
        DocumentoClinico doc = DocumentoClinicoMapper.mapToDocumento(dto, paciente);
        return DocumentoClinicoMapper.mapToDocumentoDto(documentoRepository.save(doc));
    }

    @Override
    public DocumentoClinicoDto updateDocumento(Long id, DocumentoClinicoDto dto) {
        DocumentoClinico existing = documentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DocumentoClinico no encontrado con id: " + id));
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + dto.getPacienteId()));

        existing.setPaciente(paciente);
        existing.setTipo(dto.getTipo());
        existing.setUrl(dto.getUrl());

        return DocumentoClinicoMapper.mapToDocumentoDto(documentoRepository.save(existing));
    }

    @Override
    public void deleteDocumento(Long id) {
        DocumentoClinico existing = documentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DocumentoClinico no encontrado con id: " + id));
        documentoRepository.delete(existing);
    }
}
