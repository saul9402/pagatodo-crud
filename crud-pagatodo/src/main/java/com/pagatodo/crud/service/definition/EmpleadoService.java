package com.pagatodo.crud.service.definition;

import com.pagatodo.crud.persistence.entity.Empleado;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpleadoService extends BaseCRUD<Empleado, Long> {

    List<Empleado> getEmpleadosByIdDepartamentoSP(@Param("id_departamento") Integer idDepartamento);
}
