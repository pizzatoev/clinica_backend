package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.EncuentroDto;
import org.example.clinica_backend.services.EncuentroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/encuentros")
public class EncuentroController {

    private final EncuentroService encuentroService;

    @GetMapping
    public ResponseEntity<List<EncuentroDto>> getAllEncuentros() {
        return ResponseEntity.ok(encuentroService.getAllEncuentros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncuentroDto> getEncuentroById(@PathVariable Long id) {
        return ResponseEntity.ok(encuentroService.getEncuentroById(id));
    }

    @PostMapping
    public ResponseEntity<EncuentroDto> createEncuentro(@RequestBody EncuentroDto dto) {
        return new ResponseEntity<>(encuentroService.createEncuentro(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncuentroDto> updateEncuentro(@PathVariable Long id, @RequestBody EncuentroDto dto) {
        return ResponseEntity.ok(encuentroService.updateEncuentro(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncuentro(@PathVariable Long id) {
        encuentroService.deleteEncuentro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
