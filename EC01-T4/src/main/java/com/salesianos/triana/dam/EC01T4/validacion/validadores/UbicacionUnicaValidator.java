package com.salesianos.triana.dam.EC01T4.validacion.validadores;

import org.springframework.util.StringUtils;
import com.salesianos.triana.dam.EC01T4.services.EstacionServicio;
import com.salesianos.triana.dam.EC01T4.validacion.anotaciones.UbicacionUnica;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UbicacionUnicaValidator implements ConstraintValidator<UbicacionUnica, String> {

    @Autowired
    private EstacionServicio servicio;

    @Override
    public void initialize(UbicacionUnica constraintAnnotation) {

    }

    @Override
    public boolean isValid(String ubicacion, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(ubicacion) && ! servicio.comprobarUbicacion(ubicacion);
    }
}
