package org.example.clinica_backend.dtos;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import org.example.clinica_backend.enums.TipoEncuentro;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EncuentroDto {
    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private LocalDateTime fecha;
    private TipoEncuentro tipo; // API devuelve "CONSULTA"
    private String motivo;
    private List<DiagnosticoDto> diagnosticos;
    private List<ProcedimientoDto> procedimientos;
}
