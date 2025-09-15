package org.example.clinica_backend.dtos;

import jakarta.validation.constraints.*;
import lombok.*;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DiagnosticoDto {
    private Long id;
    @NotBlank @Size(max = 10) private String codigoCie10;
    private String descripcion;
    private boolean principal;
}
