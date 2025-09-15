package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.Procedimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProcedimientoRepository extends JpaRepository<Procedimiento, Long> {
    List<Procedimiento> findByEncuentro_Id(Long encuentroId);
}