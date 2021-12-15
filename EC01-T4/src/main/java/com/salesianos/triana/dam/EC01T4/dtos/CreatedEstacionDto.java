package com.salesianos.triana.dam.EC01T4.dtos;

import com.salesianos.triana.dam.EC01T4.validacion.anotaciones.FechasVal;
import com.salesianos.triana.dam.EC01T4.validacion.anotaciones.UbicacionUnica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@FechasVal (fechaAperturaField = "fechaApertura", fechaRegistroField = "fechaRegistro", message = "{estacion.fechas}")
public class CreatedEstacionDto {

    @NotBlank ( message = "{estacion.nombre.blank}")
    private String nombre;

    @NotNull ( message =  "{estacion.marca.nNull}")
    private String marca;

    @Pattern(regexp = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$", message = "{estacion.ubicacion.exp}")
    @UbicacionUnica(message = "{estacion.ubicacion.UbicacionUnica}")
    @NotBlank(message = "{estacion.ubicacion.blank}")
    private String ubicacion;

    @Builder.Default
    private boolean tieneAutoLavado = false;

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

    @NotNull
    @Builder.Default
    @Past (message = "{estacion.fechaApertura.past}")
    private LocalDateTime fechaApertura = LocalDateTime.now().plusMinutes(1);

    @NotNull
    @Builder.Default
    private LocalDateTime fechaRegistro = LocalDateTime.now();
}
