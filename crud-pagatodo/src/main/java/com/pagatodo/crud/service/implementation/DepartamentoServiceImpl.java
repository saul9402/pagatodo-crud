package com.pagatodo.crud.service.implementation;

import com.pagatodo.crud.exception.types.RegisterNotFoundException;
import com.pagatodo.crud.persistence.entity.Departamento;
import com.pagatodo.crud.persistence.repository.BaseRepository;
import com.pagatodo.crud.persistence.repository.departamentos.DepartamentoRepository;
import com.pagatodo.crud.service.definition.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl extends BaseCRUDImpl<Departamento, Integer> implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    @Override
    protected BaseRepository<Departamento, Integer> getRepositoryBean() {
        return departamentoRepository;
    }

    @Override
    public Departamento updateNombreDepartamento(Integer idDepartamento, String nuevoNombre) {
        departamentoRepository.updateNombreDepartamento(idDepartamento, nuevoNombre);
        return departamentoRepository.findById(idDepartamento).orElseThrow(() -> new RegisterNotFoundException("Not found elements"));
    }
}
