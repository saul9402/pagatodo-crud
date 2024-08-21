package com.pagatodo.crud.persistence.repository.empleados;


import com.pagatodo.crud.persistence.entity.Empleado;
import com.pagatodo.crud.persistence.repository.BaseRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface EmpleadoBaseRepository extends BaseRepository<Empleado, Long> {

    List<Empleado> getEmpleadosByIdDepartamentoSP(@Param("id_departamento_in") Integer idDepartamento);
}
