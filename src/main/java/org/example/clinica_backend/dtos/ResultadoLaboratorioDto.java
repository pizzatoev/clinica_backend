package org.example.clinica_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoLaboratorioDto {
    private Long id;
    private Long ordenId;
    private String valor;
    private String unidad;
    private String rangoReferencia;
}
