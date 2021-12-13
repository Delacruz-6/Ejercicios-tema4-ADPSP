package com.salesianos.triana.dam.EC01T4.controllers;

import com.salesianos.triana.dam.EC01T4.models.EstacionDeServicio;
import com.salesianos.triana.dam.EC01T4.services.EstacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacion")
public class EstacionController {

    private final EstacionServicio servicio;


    @GetMapping("/")
    public List<EstacionDeServicio> getAll(){

        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public EstacionDeServicio getOne (@PathVariable Long id){

        return servicio.findById(id);
    }

    @PostMapping("/")
    public EstacionDeServicio save (@Valid @RequestBody EstacionDeServicio estacion){

        return servicio.save(estacion);
    }


    @PutMapping("/{id}")
    public EstacionDeServicio editar (@Valid  @RequestBody EstacionDeServicio estacion , @PathVariable Long id){
        return servicio.editar(estacion, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@Valid @PathVariable Long id){
        servicio.delete(id);
        return ResponseEntity.noContent().build();

    }

}
