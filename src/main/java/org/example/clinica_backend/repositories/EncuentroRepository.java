package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.Encuentro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface EncuentroRepository extends JpaRepository<Encuentro, Long> {
    List<Encuentro> findByPaciente_Id(Long pacienteId);
    List<Encuentro> findByMedico_Id(Long medicoId);
}
