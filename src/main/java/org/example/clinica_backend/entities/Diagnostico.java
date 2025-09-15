package org.example.clinica_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "diagnostico")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diagnostico")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "encuentro_id", nullable = false)
    private Encuentro encuentro;

    @Column(name = "codigo_cie10", nullable = false, length = 10)
    private String codigoCie10;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "principal", nullable = false)
    private boolean principal = false;
}
