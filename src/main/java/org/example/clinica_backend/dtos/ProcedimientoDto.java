package org.example.clinica_backend.dtos;

import jakarta.validation.constraints.*;
import lombok.*;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProcedimientoDto {
    private Long id;
    @NotBlank @Size(max = 50) private String codigo;
    private String descripcion;
}