package com.salesianos.triana.dam.EC01T4.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class EstacionDeServicio {

    @GeneratedValue
    @Id
    private Long id;

    private String nombre;

    private String marca;

    private String ubicacion;

    @Builder.Default  //No funciona
    private Boolean tieneAutoLavado = false;

    private Float precioGasoilNormal;

    private Float precioGasolina95Octavos;

    private Float precioGasolina98;

    private Float precioGasoilEspecial;

    @Lob
    private String servicios;

    private LocalDateTime fechaApertura;






}
