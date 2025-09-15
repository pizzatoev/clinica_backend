package org.example.clinica_backend.servicesimpls;

import lombok.AllArgsConstructor;
import org.example.clinica_backend.dtos.ResultadoLaboratorioDto;
import org.example.clinica_backend.entities.OrdenLaboratorio;
import org.example.clinica_backend.entities.ResultadoLaboratorio;
import org.example.clinica_backend.exceptions.ResourceNotFoundException;
import org.example.clinica_backend.mapperdtos.ResultadoLaboratorioMapper;
import org.example.clinica_backend.repositories.OrdenLaboratorioRepository;
import org.example.clinica_backend.repositories.ResultadoLaboratorioRepository;
import org.example.clinica_backend.services.ResultadoLaboratorioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResultadoLaboratorioServiceImpl implements ResultadoLaboratorioService {

    private final ResultadoLaboratorioRepository resultadoRepository;
    private final OrdenLaboratorioRepository ordenRepository;

    @Override
    public List<ResultadoLaboratorioDto> getAllResultados() {
        return resultadoRepository.findAll()
                .stream()
                .map(ResultadoLaboratorioMapper::mapToResultadoDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResultadoLaboratorioDto getResultadoById(Long id) {
        ResultadoLaboratorio resultado = resultadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResultadoLaboratorio no encontrado con id: " + id));
        return ResultadoLaboratorioMapper.mapToResultadoDto(resultado);
    }

    @Override
    public ResultadoLaboratorioDto createResultado(ResultadoLaboratorioDto dto) {
        OrdenLaboratorio orden = ordenRepository.findById(dto.getOrdenId())
                .orElseThrow(() -> new ResourceNotFoundException("OrdenLaboratorio no encontrada con id: " + dto.getOrdenId()));
        ResultadoLaboratorio resultado = ResultadoLaboratorioMapper.mapToResultado(dto, orden);
        return ResultadoLaboratorioMapper.mapToResultadoDto(resultadoRepository.save(resultado));
    }

    @Override
    public ResultadoLaboratorioDto updateResultado(Long id, ResultadoLaboratorioDto dto) {
        ResultadoLaboratorio resultado = resultadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResultadoLaboratorio no encontrado con id: " + id));
        OrdenLaboratorio orden = ordenRepository.findById(dto.getOrdenId())
                .orElseThrow(() -> new ResourceNotFoundException("OrdenLaboratorio no encontrada con id: " + dto.getOrdenId()));

        resultado.setOrden(orden);
        resultado.setValor(dto.getValor());
        resultado.setUnidad(dto.getUnidad());
        resultado.setRangoReferencia(dto.getRangoReferencia());

        return ResultadoLaboratorioMapper.mapToResultadoDto(resultadoRepository.save(resultado));
    }

    @Override
    public void deleteResultado(Long id) {
        ResultadoLaboratorio resultado = resultadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResultadoLaboratorio no encontrado con id: " + id));
        resultadoRepository.delete(resultado);
    }
}
