package com.pagatodo.crud.mapper;

import com.pagatodo.crud.dto.DepartamentoDTO;
import com.pagatodo.crud.persistence.entity.Departamento;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIoC = IoC.CDI_SINGLETON)
public interface DepartamentoMapper {

    @Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    DepartamentoDTO asDepartamentoDTO(Departamento source);

    @Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
    Departamento asDepartamento(DepartamentoDTO empleadoDTO);

}
