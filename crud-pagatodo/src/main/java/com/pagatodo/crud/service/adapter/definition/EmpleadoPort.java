package com.pagatodo.crud.service.adapter.definition;

import com.pagatodo.crud.dto.EmpleadoDTO;

import java.util.List;

public interface EmpleadoPort {

    EmpleadoDTO save(EmpleadoDTO empleado);

    EmpleadoDTO update(Long id, EmpleadoDTO empleado);

    List<EmpleadoDTO> findAll();

    List<EmpleadoDTO> findAllByDepartmentIdSP(Integer idDepartamento);

    EmpleadoDTO findById(Long id);

    void delete(Long id);
}
