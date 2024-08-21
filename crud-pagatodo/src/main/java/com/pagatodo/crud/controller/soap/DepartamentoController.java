package com.pagatodo.crud.controller.soap;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.pagatodo.crud.dto.DepartamentoDTO;
import com.pagatodo.crud.service.adapter.definition.DepartamentoPort;
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
@RequestMapping(
        value = Constants.DEPARTAMENTOS_MAPPING,
        produces = {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class DepartamentoController {

    private final DepartamentoPort departamentoPortAdapter;
    private final ObjectMapper objectMapper;
    private XmlMapper xmlMapper;

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> obtenerTodos() throws JsonProcessingException {
        return ResponseEntity.ok(departamentoPortAdapter.findAll());
    }

    @GetMapping(Constants.ID_PATH_VARIABLE)
    public ResponseEntity<DepartamentoDTO> obtenerPorId(@PathVariable Integer id) throws JsonProcessingException {
        return ResponseEntity.ok(departamentoPortAdapter.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> guardar(@Valid @RequestBody DepartamentoDTO departamentoDTO) {
        DepartamentoDTO departamentoGuardado = departamentoPortAdapter.save(departamentoDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(Constants.ID_PATH_VARIABLE).buildAndExpand(departamentoGuardado.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(Constants.ID_PATH_VARIABLE)
    public ResponseEntity<DepartamentoDTO> actualizar(@Valid @PathVariable Integer id, @RequestBody DepartamentoDTO departamentoDTO) throws JsonProcessingException {
        return ResponseEntity.ok(departamentoPortAdapter.update(id, departamentoDTO));
    }

    @PutMapping(Constants.NUEVO_NOMBRE_WITH_ID_PATH_VARIABLE)
    public ResponseEntity<DepartamentoDTO> actualizarNombre(@PathVariable Integer id, @PathVariable String nuevoNombre) throws JsonProcessingException {
        return ResponseEntity.ok(departamentoPortAdapter.updateNombreDepartamento(id, nuevoNombre));
    }

    @DeleteMapping(Constants.ID_PATH_VARIABLE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        departamentoPortAdapter.delete(id);

        return ResponseEntity.accepted().build();
    }

}
