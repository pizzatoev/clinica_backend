package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.PacienteAlergiaDto;
import org.example.clinica_backend.services.PacienteAlergiaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/paciente-alergias")
public class PacienteAlergiaController {

    private final PacienteAlergiaService pacienteAlergiaService;

    // Create
    @PostMapping
    public ResponseEntity<PacienteAlergiaDto> createPacienteAlergia(@RequestBody PacienteAlergiaDto dto){
        PacienteAlergiaDto created = pacienteAlergiaService.createPacienteAlergia(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<PacienteAlergiaDto> getPacienteAlergiaById(@PathVariable("id") Long id){
        return ResponseEntity.ok(pacienteAlergiaService.getPacienteAlergia(id));
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<PacienteAlergiaDto>> getAllPacienteAlergias(){
        return ResponseEntity.ok(pacienteAlergiaService.getPacienteAlergias());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<PacienteAlergiaDto> updatePacienteAlergia(@PathVariable("id") Long id,
                                                                    @RequestBody PacienteAlergiaDto updated){
        return ResponseEntity.ok(pacienteAlergiaService.updatePacienteAlergia(id, updated));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePacienteAlergia(@PathVariable("id") Long id){
        pacienteAlergiaService.deletePacienteAlergia(id);
        return ResponseEntity.ok("PacienteAlergia deleted successfully!.");
    }
}
