package com.pagatodo.crud.persistence.repository.empleados;


import com.pagatodo.crud.persistence.entity.Empleado;
import com.pagatodo.crud.persistence.repository.BaseRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Profile("db2")
public interface EmpleadoDB2Repository extends BaseRepository<Empleado, Long>, EmpleadoBaseRepository {

    //https://stackoverflow.com/questions/42135261/db2-sql-function-with-dynamic-return-value
    @Query(value = "select * from table (get_empleados_por_id_departamento(:id_departamento_in))", nativeQuery = true)
    List<Empleado> getEmpleadosByIdDepartamentoSP(@Param("id_departamento_in") Integer idDepartamento);
}
