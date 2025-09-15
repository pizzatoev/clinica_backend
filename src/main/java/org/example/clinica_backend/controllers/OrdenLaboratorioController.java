package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.entities.OrdenLaboratorio;
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
    public ResponseEntity<List<OrdenLaboratorio>> getAllOrdenes() {
        return ResponseEntity.ok(ordenService.getAllOrdenes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenLaboratorio> getOrdenById(@PathVariable Long id) {
        return ResponseEntity.ok(ordenService.getOrdenById(id));
    }

    @PostMapping
    public ResponseEntity<OrdenLaboratorio> createOrden(@RequestBody OrdenLaboratorio orden) {
        return new ResponseEntity<>(ordenService.createOrden(orden), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenLaboratorio> updateOrden(@PathVariable Long id, @RequestBody OrdenLaboratorio orden) {
        return ResponseEntity.ok(ordenService.updateOrden(id, orden));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable Long id) {
        ordenService.deleteOrden(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
