package com.salesianos.triana.dam.EC01T4.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
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


    @NotBlank( message = "{estacion.nombre.blank}")
    private String nombre;

    @NotNull( message =  "{estacion.marca.nNull}")
    private String marca;

    @AssertFalse( message = "{estacion.tieneAutoLavado.false}" )
    private Boolean tieneAutoLavado;

    @NotNull( message = "{estacion.precioGasoilNormal.Nnull}" )
    @PositiveOrZero( message = "{estacion.precioGasoilNormal.pO}" )
    @DecimalMin(value= "0", message = "{estacion.precioGasoilNormal.decimalMin}")
    private Float precioGasoilNormal;

    @NotNull( message = "{estacion.precioGasolina95Octavos.Nnull}" )
    @PositiveOrZero( message = "{estacion.precioGasolina95Octavos.pO}" )
    @DecimalMin(value= "0", message = "{estacion.precioGasolina95Octavos.decimalMin}")
    private Float precioGasolina95Octavos;


    @NotNull( message = "{estacion.precioGasolina98.Nnull}" )
    @PositiveOrZero( message = "{estacion.precioGasolina98.pO}" )
    @DecimalMin(value= "0", message = "{estacion.precioGasolina98.decimalMin}")
    private Float precioGasolina98;

    @Lob
    private String servicios;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    //@JsonFormat(pattern="10/04/2019")


    @Past(message = "{estacion.fechaApertura.past}")
    private LocalDateTime fechaApertura;






}
