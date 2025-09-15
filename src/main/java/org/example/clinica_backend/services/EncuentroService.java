package org.example.clinica_backend.services;

import java.util.List;
import org.example.clinica_backend.dtos.*;


public interface EncuentroService {
    EncuentroDto create(EncuentroCreateDto d);
    EncuentroDto update(Long id, EncuentroCreateDto d);
    void delete(Long id);
    EncuentroDto get(Long id);
    List<EncuentroDto> listByPaciente(Long pacienteId);
    List<EncuentroDto> listByMedico(Long medicoId);
    DiagnosticoDto addDiagnostico(Long encuentroId, DiagnosticoDto d);
    List<DiagnosticoDto> listDiagnosticos(Long encuentroId);
    ProcedimientoDto addProcedimiento(Long encuentroId, ProcedimientoDto d);
    List<ProcedimientoDto> listProcedimientos(Long encuentroId);
}