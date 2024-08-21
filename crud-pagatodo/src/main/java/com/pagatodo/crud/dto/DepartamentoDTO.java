package com.pagatodo.crud.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DepartamentoDTO {

    @EqualsAndHashCode.Include
    private Integer id;

    @NotNull
    @EqualsAndHashCode.Include
    private String nombre;

    @NotNull
    private String descripcion;

}
