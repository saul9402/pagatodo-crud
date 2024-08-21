package com.pagatodo.crud.persistence.repository.empleados;


import com.pagatodo.crud.persistence.entity.Empleado;
import com.pagatodo.crud.persistence.repository.BaseRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Profile("postgres | default")
public interface EmpleadoPostgresRepository extends BaseRepository<Empleado, Long>, EmpleadoBaseRepository {

    /*
    - https://www.squash.io/using-select-query-as-a-stored-procedure-in-postgresql/
    - https://www.baeldung.com/spring-data-jpa-stored-procedures
     */
    @Query(value = "select * from get_empleados_por_id_departamento(:id_departamento_in)", nativeQuery = true)
    List<Empleado> getEmpleadosByIdDepartamentoSP(@Param("id_departamento_in") Integer idDepartamento);
}
