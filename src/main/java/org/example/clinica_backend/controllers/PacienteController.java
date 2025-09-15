package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.PacienteDto;
import org.example.clinica_backend.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDto> createPaciente(@RequestBody PacienteDto pacienteDto){
        PacienteDto paciente = pacienteService.createPaciente(pacienteDto);
        return new ResponseEntity<>(paciente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> getPacienteById(@PathVariable("id") Long pacienteId){
        PacienteDto pacienteDto = pacienteService.getPaciente(pacienteId);
        return ResponseEntity.ok(pacienteDto);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> getAllPacientes(){
        List<PacienteDto> pacientes = pacienteService.getPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDto> updatePaciente(@PathVariable("id") Long pacienteId,
                                                      @RequestBody PacienteDto updatedPaciente){
        PacienteDto pacienteDto = pacienteService.updatePaciente(pacienteId, updatedPaciente);
        return ResponseEntity.ok(pacienteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable("id") Long pacienteId){
        pacienteService.deletePaciente(pacienteId);
        return ResponseEntity.ok("Paciente deleted successfully!.");
    }
}
