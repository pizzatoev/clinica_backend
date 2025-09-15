package org.example.clinica_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "procedimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Procedimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_procedimiento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "encuentro_id", nullable = false)
    private Encuentro encuentro;

    @Column(nullable = false, length = 50)
    private String codigo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
}
