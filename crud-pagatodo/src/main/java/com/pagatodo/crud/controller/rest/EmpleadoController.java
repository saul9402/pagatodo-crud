package com.pagatodo.crud.controller.rest;


import com.pagatodo.crud.dto.EmpleadoDTO;
import com.pagatodo.crud.service.adapter.definition.EmpleadoPort;
import com.pagatodo.crud.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = Constants.EMPLEADOS_MAPPING, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpleadoController {

    private final EmpleadoPort empleadoPortAdapter;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> obtenerTodos() {
        return ResponseEntity.ok(empleadoPortAdapter.findAll());
    }

    @GetMapping(Constants.EMPLEADOS_POR_DEPARTAMENTO_ID)
    public ResponseEntity<List<EmpleadoDTO>> obtenerTodosPorIdDepartamento(@PathVariable Integer id) {
        return ResponseEntity.ok(empleadoPortAdapter.findAllByDepartmentIdSP(id));
    }

    @GetMapping(Constants.ID_PATH_VARIABLE)
    public ResponseEntity<EmpleadoDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoPortAdapter.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> guardar(@Valid @RequestBody EmpleadoDTO empleadoDTO) {
        EmpleadoDTO empleadoGuardado = empleadoPortAdapter.save(empleadoDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" +Constants.ID_PATH_VARIABLE).buildAndExpand(empleadoGuardado.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(Constants.ID_PATH_VARIABLE)
    public ResponseEntity<EmpleadoDTO> actualizar(@Valid @PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        return ResponseEntity.ok(empleadoPortAdapter.update(id, empleadoDTO));
    }

    @DeleteMapping(Constants.ID_PATH_VARIABLE)
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        empleadoPortAdapter.delete(id);

        return ResponseEntity.accepted().build();
    }
}
