package com.pagatodo.crud.service.adapter.implementation;

import com.pagatodo.crud.dto.EmpleadoDTO;
import com.pagatodo.crud.mapper.EmpleadoMapper;
import com.pagatodo.crud.service.adapter.definition.EmpleadoPort;
import com.pagatodo.crud.service.definition.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpleadoPortAdapter implements EmpleadoPort {

    private final EmpleadoService empleadoService;
    private final EmpleadoMapper empleadoMapper;

    @Override
    public EmpleadoDTO save(EmpleadoDTO empleado) {
        return empleadoMapper.asEmpleadoDTO(empleadoService.save(empleadoMapper.asEmpleado(empleado)));
    }

    @Override
    public EmpleadoDTO update(Long id, EmpleadoDTO empleado) {
        empleado.setId(id);
        return empleadoMapper.asEmpleadoDTO(empleadoService.save(empleadoMapper.asEmpleado(empleado)));
    }

    @Override
    public List<EmpleadoDTO> findAll() {
        return empleadoService.findAll().stream().map(empleadoMapper::asEmpleadoDTO).collect(Collectors.toList());
    }

    @Override
    public List<EmpleadoDTO> findAllByDepartmentIdSP(Integer idDepartamento) {
        return empleadoService.getEmpleadosByIdDepartamentoSP(idDepartamento).stream().map(empleadoMapper::asEmpleadoDTO).collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO findById(Long id) {
        return empleadoMapper.asEmpleadoDTO(empleadoService.findById(id));
    }

    @Override
    public void delete(Long id) {
        empleadoService.delete(id);
    }
}
