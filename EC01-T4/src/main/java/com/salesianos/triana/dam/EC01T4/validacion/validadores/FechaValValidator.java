package com.salesianos.triana.dam.EC01T4.validacion.validadores;

import com.salesianos.triana.dam.EC01T4.validacion.anotaciones.FechasVal;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FechaValValidator implements ConstraintValidator<FechasVal, Object> {

    private String fechaAperturaField;
    private String fechaRegistroField;

    @Override
    public void initialize(FechasVal constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String fechaApertura = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(fechaAperturaField);
        String fechaRegistro = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(fechaRegistroField);
        return false;
    }












    //ChronoUnit compara dos temporal



    //https://github.com/lmlopezmagana/ad-psp-21-22/tree/main/27_Validacion4 readme 2.2 Validador
}
