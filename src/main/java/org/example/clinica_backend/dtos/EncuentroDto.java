package org.example.clinica_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EncuentroDto {
    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private LocalDateTime fecha;
    private String tipo;   // CONSULTA / URGENCIA / HOSPITALIZACIÓN
    private String motivo;
}
