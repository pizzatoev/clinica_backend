package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.DocumentoClinicoDto;
import org.example.clinica_backend.services.DocumentoClinicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/documentos-clinicos")
public class DocumentoClinicoController {

    private final DocumentoClinicoService documentoService;

    @GetMapping
    public ResponseEntity<List<DocumentoClinicoDto>> getAllDocumentos() {
        return ResponseEntity.ok(documentoService.getAllDocumentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoClinicoDto> getDocumentoById(@PathVariable Long id) {
        return ResponseEntity.ok(documentoService.getDocumentoById(id));
    }

    @PostMapping
    public ResponseEntity<DocumentoClinicoDto> createDocumento(@RequestBody DocumentoClinicoDto dto) {
        return new ResponseEntity<>(documentoService.createDocumento(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoClinicoDto> updateDocumento(@PathVariable Long id, @RequestBody DocumentoClinicoDto dto) {
        return ResponseEntity.ok(documentoService.updateDocumento(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        documentoService.deleteDocumento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
