package org.example.clinica_backend.dtos;

import jakarta.validation.constraints.*;
import lombok.*;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmpleadoDto {
    private Long id;
    @NotBlank @Size(max = 100) private String nombres;
    @NotBlank @Size(max = 100) private String apellidos;
    @Size(max = 100) private String especialidad;
}
