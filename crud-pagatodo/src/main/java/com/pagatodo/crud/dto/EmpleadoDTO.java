package com.pagatodo.crud.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EmpleadoDTO extends PersonaDTO {

    @EqualsAndHashCode.Include
    private Long id;

    @NotEmpty
    @EqualsAndHashCode.Include
    private String numeroEmpleado;

    @NotNull
    private BigInteger salarioBruto;

    @NotNull
    private LocalDate fechaIngreso;

    @NotNull
    private DepartamentoDTO departamento;

}
