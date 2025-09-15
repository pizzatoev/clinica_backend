package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.ResultadoLaboratorioDto;
import org.example.clinica_backend.services.ResultadoLaboratorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/resultados-laboratorio")
public class ResultadoLaboratorioController {

    private final ResultadoLaboratorioService resultadoService;

    @GetMapping
    public ResponseEntity<List<ResultadoLaboratorioDto>> getAllResultados() {
        return ResponseEntity.ok(resultadoService.getAllResultados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoLaboratorioDto> getResultadoById(@PathVariable Long id) {
        return ResponseEntity.ok(resultadoService.getResultadoById(id));
    }

    @PostMapping
    public ResponseEntity<ResultadoLaboratorioDto> createResultado(@RequestBody ResultadoLaboratorioDto dto) {
        return new ResponseEntity<>(resultadoService.createResultado(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadoLaboratorioDto> updateResultado(@PathVariable Long id, @RequestBody ResultadoLaboratorioDto dto) {
        return ResponseEntity.ok(resultadoService.updateResultado(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultado(@PathVariable Long id) {
        resultadoService.deleteResultado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
