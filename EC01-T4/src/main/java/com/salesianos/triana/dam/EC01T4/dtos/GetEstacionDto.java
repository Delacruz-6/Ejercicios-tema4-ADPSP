package com.salesianos.triana.dam.EC01T4.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Lob;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class GetEstacionDto {

    private Long id;

    private String nombre;

    private String ubicacion;

    private Float precioGasoilNormal;

    private Float precioGasolina95Octavos;

}
