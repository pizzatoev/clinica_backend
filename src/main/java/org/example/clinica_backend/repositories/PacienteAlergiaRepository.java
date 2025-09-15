package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.PacienteAlergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteAlergiaRepository extends JpaRepository<PacienteAlergia, Long> {
}
