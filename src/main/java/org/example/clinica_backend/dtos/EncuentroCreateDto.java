package org.example.clinica_backend.dtos;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import org.example.clinica_backend.enums.TipoEncuentro;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EncuentroCreateDto {
    @NotNull private Long pacienteId;
    @NotNull private Long medicoId;
    @NotNull private LocalDateTime fecha;
    @NotNull private TipoEncuentro tipo;   // en la API enviamos: "CONSULTA"
    private String motivo;
    private List<DiagnosticoDto> diagnosticos;
    private List<ProcedimientoDto> procedimientos;
}
