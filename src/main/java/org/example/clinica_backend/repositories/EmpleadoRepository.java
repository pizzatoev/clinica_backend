package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {}
