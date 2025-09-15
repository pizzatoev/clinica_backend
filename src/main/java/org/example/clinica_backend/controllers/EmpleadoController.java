package org.example.clinica_backend.controllers;

import org.example.clinica_backend.dtos.EmpleadoDto;
import org.example.clinica_backend.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin("*")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoDto create(@RequestBody EmpleadoDto empleadoDto) {
        return empleadoService.create(empleadoDto);
    }

    @PutMapping("/{id}")
    public EmpleadoDto update(@PathVariable Long id, @RequestBody EmpleadoDto empleadoDto) {
        return empleadoService.update(id, empleadoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        empleadoService.delete(id);
    }

    @GetMapping("/{id}")
    public EmpleadoDto getById(@PathVariable Long id) {
        return empleadoService.getById(id);
    }

    @GetMapping
    public List<EmpleadoDto> listAll() {
        return empleadoService.listAll();
    }
}
