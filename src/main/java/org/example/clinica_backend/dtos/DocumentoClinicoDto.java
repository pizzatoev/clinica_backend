package org.example.clinica_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoClinicoDto {
    private Long id;
    private Long pacienteId;
    private String tipo;
    private String url;
}
