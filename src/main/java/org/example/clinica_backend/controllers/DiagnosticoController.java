package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.DiagnosticoDto;
import org.example.clinica_backend.services.DiagnosticoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {

    private final DiagnosticoService diagnosticoService;

    @GetMapping
    public ResponseEntity<List<DiagnosticoDto>> getAllDiagnosticos() {
        return ResponseEntity.ok(diagnosticoService.getAllDiagnosticos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosticoDto> getDiagnosticoById(@PathVariable Long id) {
        return ResponseEntity.ok(diagnosticoService.getDiagnosticoById(id));
    }

    @PostMapping
    public ResponseEntity<DiagnosticoDto> createDiagnostico(@RequestBody DiagnosticoDto dto) {
        return new ResponseEntity<>(diagnosticoService.createDiagnostico(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiagnosticoDto> updateDiagnostico(@PathVariable Long id, @RequestBody DiagnosticoDto dto) {
        return ResponseEntity.ok(diagnosticoService.updateDiagnostico(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiagnostico(@PathVariable Long id) {
        diagnosticoService.deleteDiagnostico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
