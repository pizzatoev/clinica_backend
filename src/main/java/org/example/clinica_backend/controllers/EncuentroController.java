package org.example.clinica_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import org.example.clinica_backend.dtos.*;
import org.example.clinica_backend.services.EncuentroService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/encuentros")
@RequiredArgsConstructor
public class EncuentroController {
    private final EncuentroService service;


    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public EncuentroDto create(@Valid @RequestBody EncuentroCreateDto d){ return service.create(d); }


    @PutMapping("/{id}")
    public EncuentroDto update(@PathVariable Long id, @Valid @RequestBody EncuentroCreateDto d){ return service.update(id, d);}


    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ service.delete(id);}


    @GetMapping("/{id}") public EncuentroDto get(@PathVariable Long id){ return service.get(id);}


    @GetMapping("/paciente/{pacienteId}")
    public List<EncuentroDto> byPaciente(@PathVariable Long pacienteId){ return service.listByPaciente(pacienteId);}


    @GetMapping("/medico/{medicoId}")
    public List<EncuentroDto> byMedico(@PathVariable Long medicoId){ return service.listByMedico(medicoId);}


    // Diagnósticos
    @PostMapping("/{encuentroId}/diagnosticos") @ResponseStatus(HttpStatus.CREATED)
    public DiagnosticoDto addDx(@PathVariable Long encuentroId, @Valid @RequestBody DiagnosticoDto d){ return service.addDiagnostico(encuentroId, d);}
    @GetMapping("/{encuentroId}/diagnosticos")
    public List<DiagnosticoDto> listDx(@PathVariable Long encuentroId){ return service.listDiagnosticos(encuentroId);}


    // Procedimientos
    @PostMapping("/{encuentroId}/procedimientos") @ResponseStatus(HttpStatus.CREATED)
    public ProcedimientoDto addPr(@PathVariable Long encuentroId, @Valid @RequestBody ProcedimientoDto d){ return service.addProcedimiento(encuentroId, d);}
    @GetMapping("/{encuentroId}/procedimientos")
    public List<ProcedimientoDto> listPr(@PathVariable Long encuentroId){ return service.listProcedimientos(encuentroId);}
}