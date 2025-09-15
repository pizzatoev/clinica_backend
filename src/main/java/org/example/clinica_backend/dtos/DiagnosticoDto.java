package org.example.clinica_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoDto {
    private Long id;
    private Long encuentroId;
    private String codigoCie10;
    private String descripcion;
    private boolean principal;
}
