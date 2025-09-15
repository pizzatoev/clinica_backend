package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.DocumentoClinicoDto;
import org.example.clinica_backend.entities.DocumentoClinico;
import org.example.clinica_backend.entities.Paciente;

public class DocumentoClinicoMapper {

    public static DocumentoClinicoDto mapToDocumentoDto(DocumentoClinico doc) {
        return new DocumentoClinicoDto(
                doc.getId(),
                doc.getPaciente().getId(),
                doc.getTipo(),
                doc.getUrl()
        );
    }

    public static DocumentoClinico mapToDocumento(DocumentoClinicoDto dto, Paciente paciente) {
        DocumentoClinico doc = new DocumentoClinico();
        doc.setId(dto.getId());
        doc.setPaciente(paciente);
        doc.setTipo(dto.getTipo());
        doc.setUrl(dto.getUrl());
        return doc;
    }
}
