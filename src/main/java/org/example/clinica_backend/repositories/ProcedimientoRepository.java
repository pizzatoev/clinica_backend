package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.Procedimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimientoRepository extends JpaRepository<Procedimiento, Long> {
}
