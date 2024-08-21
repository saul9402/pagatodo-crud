package com.pagatodo.crud.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonaDTO {

    private String primerNombre;

    private String segundoNombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private LocalDate fechaNacimiento;

}
