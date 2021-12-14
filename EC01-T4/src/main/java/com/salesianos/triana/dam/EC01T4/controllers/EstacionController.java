package com.salesianos.triana.dam.EC01T4.controllers;

import com.salesianos.triana.dam.EC01T4.dtos.CreatedEstacionDto;
import com.salesianos.triana.dam.EC01T4.dtos.GetEstacionDto;
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
    public List<GetEstacionDto> getAll(){

        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public EstacionDeServicio getOne (@PathVariable Long id){

        return servicio.findById(id);
    }

    @PostMapping("/")
    public EstacionDeServicio save (@Valid @RequestBody CreatedEstacionDto estacion){

        return servicio.save(estacion);
    }


    @PutMapping("/{id}")
    public EstacionDeServicio editar (@Valid  @RequestBody CreatedEstacionDto estacion , @PathVariable Long id){
        return servicio.editar(estacion, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        servicio.delete(id);
        return ResponseEntity.noContent().build();

    }

}
