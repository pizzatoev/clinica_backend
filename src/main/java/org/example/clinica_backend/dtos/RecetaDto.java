package org.example.clinica_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecetaDto {
    private Long id;
    private Long encuentroId;
    private String medicamento;
    private String dosis;
    private String frecuencia;
    private Integer duracionDias;
}