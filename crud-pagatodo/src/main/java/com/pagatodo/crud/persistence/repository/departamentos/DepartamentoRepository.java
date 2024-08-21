package com.pagatodo.crud.persistence.repository.departamentos;

import com.pagatodo.crud.persistence.entity.Departamento;
import com.pagatodo.crud.persistence.repository.BaseRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface DepartamentoRepository extends BaseRepository<Departamento, Integer> {

    @Procedure("update_nombre_departamento")
    void updateNombreDepartamento(@Param("id_departamento") Integer idDepartamento, @Param("nuevo_nombre") String nuevoNombre);
}
