package org.example.clinica_backend.services;

import org.example.clinica_backend.dtos.ProcedimientoDto;
import java.util.List;

public interface ProcedimientoService {
    List<ProcedimientoDto> getAllProcedimientos();
    ProcedimientoDto getProcedimientoById(Long id);
    ProcedimientoDto createProcedimiento(ProcedimientoDto dto);
    ProcedimientoDto updateProcedimiento(Long id, ProcedimientoDto dto);
    void deleteProcedimiento(Long id);
}
