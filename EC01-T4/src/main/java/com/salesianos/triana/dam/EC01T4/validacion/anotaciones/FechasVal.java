package com.salesianos.triana.dam.EC01T4.validacion.anotaciones;

import com.salesianos.triana.dam.EC01T4.validacion.validadores.FechaValValidator;
import com.salesianos.triana.dam.EC01T4.validacion.validadores.UbicacionUnicaValidator;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FechaValValidator.class)
@Documented
public @interface FechasVal {

    String message() default "La fecha de apertura debe ser menor o igual a la fecha de registro";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fechaAperturaField();
    String fechaRegistroField();


}
