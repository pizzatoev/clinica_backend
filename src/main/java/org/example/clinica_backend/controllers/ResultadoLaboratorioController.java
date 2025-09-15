package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.entities.ResultadoLaboratorio;
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
    public ResponseEntity<List<ResultadoLaboratorio>> getAllResultados() {
        return ResponseEntity.ok(resultadoService.getAllResultados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoLaboratorio> getResultadoById(@PathVariable Long id) {
        return ResponseEntity.ok(resultadoService.getResultadoById(id));
    }

    @PostMapping
    public ResponseEntity<ResultadoLaboratorio> createResultado(@RequestBody ResultadoLaboratorio resultado) {
        return new ResponseEntity<>(resultadoService.createResultado(resultado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadoLaboratorio> updateResultado(@PathVariable Long id, @RequestBody ResultadoLaboratorio resultado) {
        return ResponseEntity.ok(resultadoService.updateResultado(id, resultado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultado(@PathVariable Long id) {
        resultadoService.deleteResultado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
