package org.example.clinica_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documento_clinico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento_clinico")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Column(nullable = false, length = 100)
    private String tipo;

    @Column(nullable = false, length = 500)
    private String url;
}
