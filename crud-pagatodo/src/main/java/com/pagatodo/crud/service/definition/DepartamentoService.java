package com.pagatodo.crud.service.definition;

import com.pagatodo.crud.persistence.entity.Departamento;

public interface DepartamentoService extends BaseCRUD<Departamento, Integer> {

    Departamento updateNombreDepartamento(Integer idDepartamento, String nuevoNombre);
}
