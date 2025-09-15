package org.example.clinica_backend.controllers;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.entities.DocumentoClinico;
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
    public ResponseEntity<List<DocumentoClinico>> getAllDocumentos() {
        return ResponseEntity.ok(documentoService.getAllDocumentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoClinico> getDocumentoById(@PathVariable Long id) {
        return ResponseEntity.ok(documentoService.getDocumentoById(id));
    }

    @PostMapping
    public ResponseEntity<DocumentoClinico> createDocumento(@RequestBody DocumentoClinico documento) {
        return new ResponseEntity<>(documentoService.createDocumento(documento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoClinico> updateDocumento(@PathVariable Long id, @RequestBody DocumentoClinico documento) {
        return ResponseEntity.ok(documentoService.updateDocumento(id, documento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        documentoService.deleteDocumento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
