package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.entities.Receta;
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
    public ResponseEntity<List<Receta>> getAllRecetas() {
        return ResponseEntity.ok(recetaService.getAllRecetas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receta> getRecetaById(@PathVariable Long id) {
        return ResponseEntity.ok(recetaService.getRecetaById(id));
    }

    @PostMapping
    public ResponseEntity<Receta> createReceta(@RequestBody Receta receta) {
        return new ResponseEntity<>(recetaService.createReceta(receta), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receta> updateReceta(@PathVariable Long id, @RequestBody Receta receta) {
        return ResponseEntity.ok(recetaService.updateReceta(id, receta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceta(@PathVariable Long id) {
        recetaService.deleteReceta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
