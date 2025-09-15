package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
    List<Diagnostico> findByEncuentro_Id(Long encuentroId);
}
