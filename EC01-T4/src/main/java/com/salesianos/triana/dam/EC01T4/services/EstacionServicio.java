package com.salesianos.triana.dam.EC01T4.services;

import com.salesianos.triana.dam.EC01T4.errores.excepciones.NotFoundException;
import com.salesianos.triana.dam.EC01T4.models.EstacionDeServicio;
import com.salesianos.triana.dam.EC01T4.repositories.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionServicio {

    private final EstacionRepository repositorio ;

    public List<EstacionDeServicio> findAll(){
        return repositorio.findAll();
    }

    public  EstacionDeServicio findById(Long id){
        return repositorio.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString(), EstacionDeServicio.class));
    }

    public EstacionDeServicio save (EstacionDeServicio estacion){
        return  repositorio.save(estacion);
    }

    public EstacionDeServicio editar (EstacionDeServicio editado, @PathVariable Long id){
        return repositorio.findById(id).map(e -> {
            e.setNombre(editado.getNombre());
            e.setMarca(editado.getMarca());
            e.setPrecioGasoilNormal(editado.getPrecioGasoilNormal());
            e.setPrecioGasolina98(editado.getPrecioGasolina98());
            e.setPrecioGasolina95Octavos(editado.getPrecioGasolina95Octavos());
            e.setTieneAutoLavado(editado.getTieneAutoLavado());
            e.setServicios(editado.getServicios());
            return  repositorio.save(e);
        }).orElseThrow(() -> new NotFoundException(id.toString(), EstacionDeServicio.class)
        );
    }

    public void  delete (@PathVariable Long id){
        EstacionDeServicio estacion = repositorio.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString(), EstacionDeServicio.class));
        repositorio.delete(estacion);
    }



}
