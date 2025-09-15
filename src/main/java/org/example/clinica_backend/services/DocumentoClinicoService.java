package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.DocumentoClinicoDto;
import java.util.List;

public interface DocumentoClinicoService {
    List<DocumentoClinicoDto> getAllDocumentos();
    DocumentoClinicoDto getDocumentoById(Long id);
    DocumentoClinicoDto createDocumento(DocumentoClinicoDto dto);
    DocumentoClinicoDto updateDocumento(Long id, DocumentoClinicoDto dto);
    void deleteDocumento(Long id);
}
