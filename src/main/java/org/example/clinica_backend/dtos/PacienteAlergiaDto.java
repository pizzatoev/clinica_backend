package org.example.clinica_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteAlergiaDto {
    private Long id;
    private Long pacienteId;
    private Long alergiaId;
    private String severidad; // "LEVE", "MODERADA", "SEVERA"
}
