package org.example.clinica_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class PacienteDto {
    private Long id;
    private String nombres;
    private String apellidos;
    private String documento;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String grupoSanguineo;
    private String alergiasResumen;

    private Set<Long> alergiaIds;
}

