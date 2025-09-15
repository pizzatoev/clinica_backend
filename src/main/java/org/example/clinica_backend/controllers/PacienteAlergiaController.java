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

    private final PacienteAlergiaService paService;

    @GetMapping
    public ResponseEntity<List<PacienteAlergiaDto>> getAll() {
        return ResponseEntity.ok(paService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteAlergiaDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(paService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PacienteAlergiaDto> create(@RequestBody PacienteAlergiaDto dto) {
        return new ResponseEntity<>(paService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteAlergiaDto> update(@PathVariable Long id, @RequestBody PacienteAlergiaDto dto) {
        return ResponseEntity.ok(paService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
