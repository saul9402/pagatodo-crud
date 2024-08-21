package com.pagatodo.crud.service.implementation;

import com.pagatodo.crud.persistence.entity.Empleado;
import com.pagatodo.crud.persistence.repository.BaseRepository;
import com.pagatodo.crud.persistence.repository.empleados.EmpleadoBaseRepository;
import com.pagatodo.crud.service.definition.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl extends BaseCRUDImpl<Empleado, Long> implements EmpleadoService {

    private final EmpleadoBaseRepository empleadoRepository;

    @Override
    protected BaseRepository<Empleado, Long> getRepositoryBean() {
        return this.empleadoRepository;
    }

    @Override
    public List<Empleado> getEmpleadosByIdDepartamentoSP(Integer idDepartamento) {
        return empleadoRepository.getEmpleadosByIdDepartamentoSP(idDepartamento);
    }
}
