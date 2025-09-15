package org.example.clinica_backend.repositories;

import org.example.clinica_backend.entities.Alergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlergiaRepository extends JpaRepository<Alergia, Long> {
}
