package org.example.clinica_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PacienteAlergiaDto {
    private Long id;
    private Long pacienteId;
    private Long alergiaId;
    private String severidad;
}
