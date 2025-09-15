package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.DocumentoClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoClinicoRepository extends JpaRepository<DocumentoClinico, Long> {
}
