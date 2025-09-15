package org.example.clinica_backend.mapperdtos;

import java.util.List;

import org.example.clinica_backend.dtos.DiagnosticoDto;
import org.example.clinica_backend.dtos.EncuentroCreateDto;
import org.example.clinica_backend.dtos.EncuentroDto;
import org.example.clinica_backend.dtos.ProcedimientoDto;
import org.example.clinica_backend.entities.Empleado;
import org.example.clinica_backend.entities.Encuentro;
import org.example.clinica_backend.entities.Paciente;
import org.example.clinica_backend.enums.TipoEncuentro;
import org.springframework.stereotype.Component;

@Component
public class EncuentroMapper {

    private final DiagnosticoMapper diagnosticoMapper;
    private final ProcedimientoMapper procedimientoMapper;

    public EncuentroMapper(DiagnosticoMapper diagnosticoMapper,
                           ProcedimientoMapper procedimientoMapper) {
        this.diagnosticoMapper = diagnosticoMapper;
        this.procedimientoMapper = procedimientoMapper;
    }

    /** Entidad -> DTO (campos principales) */
    public EncuentroDto toDto(Encuentro e) {
        if (e == null) return null;
        EncuentroDto dto = new EncuentroDto();
        dto.setId(e.getId());
        dto.setPacienteId(e.getPaciente() != null ? e.getPaciente().getId() : null);
        dto.setMedicoId(e.getMedico() != null ? e.getMedico().getId() : null);
        dto.setFecha(e.getFecha());
        dto.setTipo(e.getTipo() != null ? TipoEncuentro.fromDb(e.getTipo()) : null);
        dto.setMotivo(e.getMotivo());
        // Las listas (diagnósticos/procedimientos) se pueden llenar aparte con fillChildren(...)
        return dto;
    }

    /**
     * Crea la entidad a partir del CreateDto y referencias ya cargadas
     * (Paciente y Empleado recuperados del repositorio).
     */
    public Encuentro toEntityForCreate(EncuentroCreateDto dto, Paciente paciente, Empleado medico) {
        if (dto == null) return null;
        Encuentro e = new Encuentro();
        e.setPaciente(paciente);
        e.setMedico(medico);
        e.setFecha(dto.getFecha());
        e.setTipo(dto.getTipo() != null ? dto.getTipo().getDbValue() : null); // guarda "Consulta/Urgencia/Hospitalización"
        e.setMotivo(dto.getMotivo());
        return e;
    }

    /** Helper para adjuntar listas ya mapeadas al DTO (opcional). */
    public void fillChildren(EncuentroDto dto,
                             List<DiagnosticoDto> diagnosticos,
                             List<ProcedimientoDto> procedimientos) {
        if (dto != null) {
            dto.setDiagnosticos(diagnosticos);
            dto.setProcedimientos(procedimientos);
        }
    }

    /** Helpers por si quieres convertir listas de entidades a DTOs desde el servicio. */
    public List<DiagnosticoDto> toDiagnosticoDtos(List<org.example.clinica_backend.entities.Diagnostico> list) {
        return list == null ? null : list.stream().map(diagnosticoMapper::toDto).toList();
    }

    public List<ProcedimientoDto> toProcedimientoDtos(List<org.example.clinica_backend.entities.Procedimiento> list) {
        return list == null ? null : list.stream().map(procedimientoMapper::toDto).toList();
    }
}
