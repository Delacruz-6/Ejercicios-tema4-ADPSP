package com.salesianos.triana.dam.EC01T4.dtos;

import com.salesianos.triana.dam.EC01T4.models.EstacionDeServicio;
import org.springframework.stereotype.Component;

@Component
public class ConverterEstacion {

    public EstacionDeServicio createdEstacionToDto (CreatedEstacionDto c){

        return EstacionDeServicio.builder()
                .nombre(c.getNombre())
                .ubicacion(c.getUbicacion())
                .marca(c.getMarca())
                .tieneAutoLavado(c.isTieneAutoLavado())
                .precioGasoilNormal(c.getPrecioGasoilNormal())
                .precioGasolina98(c.getPrecioGasolina98())
                .precioGasoilEspecial(c.getPrecioGasoilEspecial())
                .precioGasolina95Octavos(c.getPrecioGasolina95Octavos())
                .fechaApertura(c.getFechaApertura())
                .fechaRegistro(c.getFechaRegistro())
                .servicios(c.getServicios())
                .build();

    }

    public GetEstacionDto getEstacionToDto (EstacionDeServicio e){
        return GetEstacionDto.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .ubicacion(e.getUbicacion())
                .precioGasoilNormal(e.getPrecioGasoilNormal())
                .precioGasolina95Octavos(e.getPrecioGasolina95Octavos())
                .build();
    }

}
