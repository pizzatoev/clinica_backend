package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.EmpleadoDto;
import org.example.clinica_backend.services.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<EmpleadoDto>> getAllEmpleados() {
        return ResponseEntity.ok(empleadoService.getAllEmpleados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDto> getEmpleadoById(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.getEmpleadoById(id));
    }

    @PostMapping
    public ResponseEntity<EmpleadoDto> createEmpleado(@RequestBody EmpleadoDto dto) {
        return new ResponseEntity<>(empleadoService.createEmpleado(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDto> updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoDto dto) {
        return ResponseEntity.ok(empleadoService.updateEmpleado(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
