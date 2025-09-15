package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.PacienteAlergia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PacienteAlergiaRepository extends JpaRepository<PacienteAlergia, Long> {
    boolean existsByPaciente_IdAndAlergia_Id(Long pacienteId, Long alergiaId);
    Optional<PacienteAlergia> findByPaciente_IdAndAlergia_Id(Long pacienteId, Long alergiaId);
    List<PacienteAlergia> findByPaciente_Id(Long pacienteId);
    List<PacienteAlergia> findByAlergia_Id(Long alergiaId);
}
