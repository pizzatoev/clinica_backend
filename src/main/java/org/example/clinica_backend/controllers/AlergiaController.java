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

    // Create
    @PostMapping
    public ResponseEntity<AlergiaDto> createAlergia(@RequestBody AlergiaDto alergiaDto){
        AlergiaDto alergia = alergiaService.createAlergia(alergiaDto);
        return new ResponseEntity<>(alergia, HttpStatus.CREATED);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<AlergiaDto> getAlergiaById(@PathVariable("id") Long alergiaId){
        AlergiaDto dto = alergiaService.getAlergia(alergiaId);
        return ResponseEntity.ok(dto);
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<AlergiaDto>> getAllAlergias(){
        List<AlergiaDto> list = alergiaService.getAlergias();
        return ResponseEntity.ok(list);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<AlergiaDto> updateAlergia(@PathVariable("id") Long alergiaId,
                                                    @RequestBody AlergiaDto updated){
        AlergiaDto dto = alergiaService.updateAlergia(alergiaId, updated);
        return ResponseEntity.ok(dto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlergia(@PathVariable("id") Long alergiaId){
        alergiaService.deleteAlergia(alergiaId);
        return ResponseEntity.ok("Alergia deleted successfully!.");
    }
}
