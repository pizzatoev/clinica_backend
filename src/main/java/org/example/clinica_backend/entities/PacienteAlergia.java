package org.example.clinica_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Paciente_Alergia")
@Data @NoArgsConstructor @AllArgsConstructor
public class PacienteAlergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_paciente",
            referencedColumnName = "IdPaciente",
            foreignKey = @ForeignKey(name = "fk_pa_paciente"),
            nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_alergia",
            referencedColumnName = "IdAlergia",
            foreignKey = @ForeignKey(name = "fk_pa_alergia"),
            nullable = false)
    private Alergia alergia;

    @Column(name = "Severidad", nullable = false, length = 9)
    private String severidad;
}

