package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.ProcedimientoDto;
import org.example.clinica_backend.services.ProcedimientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/procedimientos")
public class ProcedimientoController {

    private final ProcedimientoService procedimientoService;

    @GetMapping
    public ResponseEntity<List<ProcedimientoDto>> getAllProcedimientos() {
        return ResponseEntity.ok(procedimientoService.getAllProcedimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcedimientoDto> getProcedimientoById(@PathVariable Long id) {
        return ResponseEntity.ok(procedimientoService.getProcedimientoById(id));
    }

    @PostMapping
    public ResponseEntity<ProcedimientoDto> createProcedimiento(@RequestBody ProcedimientoDto dto) {
        return new ResponseEntity<>(procedimientoService.createProcedimiento(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcedimientoDto> updateProcedimiento(@PathVariable Long id, @RequestBody ProcedimientoDto dto) {
        return ResponseEntity.ok(procedimientoService.updateProcedimiento(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcedimiento(@PathVariable Long id) {
        procedimientoService.deleteProcedimiento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
