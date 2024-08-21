package com.pagatodo.crud.mapper;

import com.pagatodo.crud.dto.EmpleadoDTO;
import com.pagatodo.crud.persistence.entity.Empleado;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIoC = IoC.CDI_SINGLETON)
public interface EmpleadoMapper {

    @Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    EmpleadoDTO asEmpleadoDTO(Empleado source);

    @Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
    Empleado asEmpleado(EmpleadoDTO source);

}
