package org.example.clinica_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "receta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "encuentro_id", nullable = false)
    private Encuentro encuentro;

    @Column(nullable = false, length = 150)
    private String medicamento;

    @Column(nullable = false, length = 100)
    private String dosis;

    @Column(nullable = false, length = 100)
    private String frecuencia;

    @Column(name = "duracion_dias", nullable = false)
    private Integer duracionDias;
}
