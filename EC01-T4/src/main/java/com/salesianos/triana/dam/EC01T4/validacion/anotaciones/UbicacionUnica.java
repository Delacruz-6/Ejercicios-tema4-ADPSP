package com.salesianos.triana.dam.EC01T4.validacion.anotaciones;
import com.salesianos.triana.dam.EC01T4.validacion.validadores.UbicacionUnicaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UbicacionUnicaValidator.class)
@Documented
public @interface UbicacionUnica {

    String message() default "La ubicación debe ser única";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
