package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.Encuentro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuentroRepository extends JpaRepository<Encuentro, Long> {
}
