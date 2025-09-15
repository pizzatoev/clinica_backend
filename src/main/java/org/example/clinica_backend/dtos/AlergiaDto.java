package org.example.clinica_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class AlergiaDto {
    private Long id;
    private String nombre;
    private String descripcion;

    private Set<Long> pacienteIds;
}


