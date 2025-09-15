package org.example.clinica_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orden_laboratorio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_laboratorio")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "encuentro_id", nullable = false)
    private Encuentro encuentro;

    @Column(nullable = false, length = 150)
    private String examen;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoOrden estado = EstadoOrden.SOLICITADO;

    public enum EstadoOrden {
        SOLICITADO,
        TOMADO,
        REPORTADO
    }
}
