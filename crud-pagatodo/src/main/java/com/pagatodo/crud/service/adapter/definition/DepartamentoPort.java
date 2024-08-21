package com.pagatodo.crud.service.adapter.definition;

import com.pagatodo.crud.dto.DepartamentoDTO;

import java.util.List;

public interface DepartamentoPort {

    DepartamentoDTO save(DepartamentoDTO departamentoDTO);

    DepartamentoDTO update(Integer id, DepartamentoDTO departamentoDTO);

    List<DepartamentoDTO> findAll();

    DepartamentoDTO findById(Integer id);

    void delete(Integer id);

    DepartamentoDTO updateNombreDepartamento(Integer idDepartamento, String nuevoNombre);
}
