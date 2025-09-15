package org.example.clinica_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenLaboratorioDto {
    private Long id;
    private Long encuentroId;
    private String examen;
    private String estado; // "Solicitado", "Tomado", "Reportado"
}
