package org.example.clinica_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "encuentro")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Encuentro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encuentro")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medico_id", nullable = false)
    private Empleado medico;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    // Guardamos el valor textual exacto del ENUM en MySQL: "Consulta", "Urgencia", "Hospitalización"
    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;

    @Column(name = "motivo", columnDefinition = "TEXT")
    private String motivo;
}
