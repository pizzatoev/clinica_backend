package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.OrdenLaboratorioDto;
import org.example.clinica_backend.services.OrdenLaboratorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/ordenes-laboratorio")
public class OrdenLaboratorioController {

    private final OrdenLaboratorioService ordenService;

    @GetMapping
    public ResponseEntity<List<OrdenLaboratorioDto>> getAllOrdenes() {
        return ResponseEntity.ok(ordenService.getAllOrdenes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenLaboratorioDto> getOrdenById(@PathVariable Long id) {
        return ResponseEntity.ok(ordenService.getOrdenById(id));
    }

    @PostMapping
    public ResponseEntity<OrdenLaboratorioDto> createOrden(@RequestBody OrdenLaboratorioDto dto) {
        return new ResponseEntity<>(ordenService.createOrden(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenLaboratorioDto> updateOrden(@PathVariable Long id, @RequestBody OrdenLaboratorioDto dto) {
        return ResponseEntity.ok(ordenService.updateOrden(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable Long id) {
        ordenService.deleteOrden(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
