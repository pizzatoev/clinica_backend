package org.example.clinica_backend.mapperdtos;

import org.example.clinica_backend.dtos.ResultadoLaboratorioDto;
import org.example.clinica_backend.entities.ResultadoLaboratorio;
import org.example.clinica_backend.entities.OrdenLaboratorio;

public class ResultadoLaboratorioMapper {

    public static ResultadoLaboratorioDto mapToResultadoDto(ResultadoLaboratorio resultado) {
        return new ResultadoLaboratorioDto(
                resultado.getId(),
                resultado.getOrden().getId(),
                resultado.getValor(),
                resultado.getUnidad(),
                resultado.getRangoReferencia()
        );
    }

    public static ResultadoLaboratorio mapToResultado(ResultadoLaboratorioDto dto, OrdenLaboratorio orden) {
        ResultadoLaboratorio resultado = new ResultadoLaboratorio();
        resultado.setId(dto.getId());
        resultado.setOrden(orden);
        resultado.setValor(dto.getValor());
        resultado.setUnidad(dto.getUnidad());
        resultado.setRangoReferencia(dto.getRangoReferencia());
        return resultado;
    }
}
