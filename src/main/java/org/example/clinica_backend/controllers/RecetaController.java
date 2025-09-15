package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.RecetaDto;
import org.example.clinica_backend.services.RecetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/recetas")
public class RecetaController {

    private final RecetaService recetaService;

    @GetMapping
    public ResponseEntity<List<RecetaDto>> getAllRecetas() {
        return ResponseEntity.ok(recetaService.getAllRecetas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecetaDto> getRecetaById(@PathVariable Long id) {
        return ResponseEntity.ok(recetaService.getRecetaById(id));
    }

    @PostMapping
    public ResponseEntity<RecetaDto> createReceta(@RequestBody RecetaDto dto) {
        return new ResponseEntity<>(recetaService.createReceta(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecetaDto> updateReceta(@PathVariable Long id, @RequestBody RecetaDto dto) {
        return ResponseEntity.ok(recetaService.updateReceta(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceta(@PathVariable Long id) {
        recetaService.deleteReceta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
