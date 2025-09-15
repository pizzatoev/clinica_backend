package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
