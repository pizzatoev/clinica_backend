package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.Alergia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlergiaRepository extends JpaRepository<Alergia, Long> { }
