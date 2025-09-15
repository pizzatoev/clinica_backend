package org.example.clinica_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "paciente_alergia",
        uniqueConstraints = @UniqueConstraint(columnNames = {"Id_paciente", "Id_alergia"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteAlergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPaciente_Alergia")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_alergia", nullable = false)
    private Alergia alergia;

    @Column(nullable = false)
    private String severidad; // Ahora es String (LEVE, MODERADA, SEVERA)
}
