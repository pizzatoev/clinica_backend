package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.OrdenLaboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenLaboratorioRepository extends JpaRepository<OrdenLaboratorio, Long> {
}
