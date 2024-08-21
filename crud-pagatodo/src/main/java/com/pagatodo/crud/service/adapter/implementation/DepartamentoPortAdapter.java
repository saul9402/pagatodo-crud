package com.pagatodo.crud.service.adapter.implementation;

import com.pagatodo.crud.dto.DepartamentoDTO;
import com.pagatodo.crud.mapper.DepartamentoMapper;
import com.pagatodo.crud.service.adapter.definition.DepartamentoPort;
import com.pagatodo.crud.service.definition.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartamentoPortAdapter implements DepartamentoPort {

    private final DepartamentoService departamentoService;
    private final DepartamentoMapper departamentoMapper;

    @Override
    public DepartamentoDTO save(DepartamentoDTO departamentoDTO) {
        return departamentoMapper.asDepartamentoDTO(departamentoService.save(departamentoMapper.asDepartamento(departamentoDTO)));
    }

    @Override
    public DepartamentoDTO update(Integer id, DepartamentoDTO departamentoDTO) {
        departamentoDTO.setId(id);
        return departamentoMapper.asDepartamentoDTO(departamentoService.save(departamentoMapper.asDepartamento(departamentoDTO)));
    }

    @Override
    public List<DepartamentoDTO> findAll() {
        return departamentoService.findAll().stream().map(departamentoMapper::asDepartamentoDTO).collect(Collectors.toList());
    }

    @Override
    public DepartamentoDTO findById(Integer id) {
        return departamentoMapper.asDepartamentoDTO(departamentoService.findById(id));
    }

    @Override
    public void delete(Integer id) {
        departamentoService.delete(id);
    }

    @Override
    public DepartamentoDTO updateNombreDepartamento(Integer idDepartamento, String nuevoNombre) {
        return departamentoMapper.asDepartamentoDTO(departamentoService.updateNombreDepartamento(idDepartamento, nuevoNombre));
    }
}
