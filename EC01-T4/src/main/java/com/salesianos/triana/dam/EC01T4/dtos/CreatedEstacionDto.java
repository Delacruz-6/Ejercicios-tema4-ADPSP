package com.salesianos.triana.dam.EC01T4.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class CreatedEstacionDto {

    @NotBlank ( message = "{estacion.nombre.blank}")
    private String nombre;

    @NotNull ( message =  "{estacion.marca.nNull}")
    private String marca;

    @NotBlank(message = "{estacion.ubicacion.blank}")
    private String ubicacion;

    @Builder.Default //No funciona
    private Boolean tieneAutoLavado = false;

    @NotNull( message = "{estacion.precioGasoilNormal.Nnull}" )
    @Digits (integer = 1, fraction = 3, message = "{estacion.precioGasoilNormal.digit}" )
    @DecimalMin (value = "0.0", inclusive = false, message = "{estacion.precioGasoilNormal.decimalMin}")
    private Float precioGasoilNormal;

    @NotNull( message = "{estacion.precioGasolina95Octavos.Nnull}" )
    @Digits(integer = 1, fraction = 3,message = "{estacion.precioGasoilina95Octavos.digit}" )
    @DecimalMin(value = "0.0", inclusive = false, message = "{estacion.precioGasolina95Octavos.decimalMin}")
    private Float precioGasolina95Octavos;

    @Digits(integer = 1, fraction = 3,message = "{estacion.precioGasolina98.digit}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{estacion.precioGasolina98.decimalMin}")
    private Float precioGasolina98;

    @Digits(integer = 1, fraction = 3,message = "{estacion.precioGasolEspecial.digit}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{estacion.precioGasolEspecial.decimalMin}")
    private Float precioGasoilEspecial;

    @Lob
    private String servicios;

    @Past (message = "{estacion.fechaApertura.past}")
    private LocalDateTime fechaApertura;
}
