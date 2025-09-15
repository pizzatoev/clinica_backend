package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.RecetaDto;
import org.example.clinica_backend.entities.Receta;
import org.example.clinica_backend.entities.Encuentro;

public class RecetaMapper {

    public static RecetaDto mapToRecetaDto(Receta receta) {
        return new RecetaDto(
                receta.getId(),
                receta.getEncuentro().getId(),
                receta.getMedicamento(),
                receta.getDosis(),
                receta.getFrecuencia(),
                receta.getDuracionDias()
        );
    }

    public static Receta mapToReceta(RecetaDto dto, Encuentro encuentro) {
        Receta receta = new Receta();
        receta.setId(dto.getId());
        receta.setEncuentro(encuentro);
        receta.setMedicamento(dto.getMedicamento());
        receta.setDosis(dto.getDosis());
        receta.setFrecuencia(dto.getFrecuencia());
        receta.setDuracionDias(dto.getDuracionDias());
        return receta;
    }
}
