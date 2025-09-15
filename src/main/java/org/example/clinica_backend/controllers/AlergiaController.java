package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.AlergiaDto;
import org.example.clinica_backend.services.AlergiaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/alergias")
public class AlergiaController {

    private final AlergiaService alergiaService;

    @GetMapping
    public ResponseEntity<List<AlergiaDto>> getAllAlergias() {
        return ResponseEntity.ok(alergiaService.getAllAlergias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlergiaDto> getAlergiaById(@PathVariable Long id) {
        return ResponseEntity.ok(alergiaService.getAlergiaById(id));
    }

    @PostMapping
    public ResponseEntity<AlergiaDto> createAlergia(@RequestBody AlergiaDto dto) {
        return new ResponseEntity<>(alergiaService.createAlergia(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlergiaDto> updateAlergia(@PathVariable Long id, @RequestBody AlergiaDto dto) {
        return ResponseEntity.ok(alergiaService.updateAlergia(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlergia(@PathVariable Long id) {
        alergiaService.deleteAlergia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
