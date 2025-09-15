package org.example.clinica_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resultado_laboratorio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultado_laboratorio")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orden_id", nullable = false)
    private OrdenLaboratorio orden;

    @Column(length = 100)
    private String valor;

    @Column(length = 50)
    private String unidad;

    @Column(name = "rango_referencia", length = 100)
    private String rangoReferencia;
}
