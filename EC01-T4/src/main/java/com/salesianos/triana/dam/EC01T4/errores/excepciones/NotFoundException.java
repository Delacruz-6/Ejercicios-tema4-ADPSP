package com.salesianos.triana.dam.EC01T4.errores.excepciones;

public class NotFoundException  extends RuntimeException{
    public NotFoundException(String id, Class clazz) {
        super(String.format("No se puede encontrar una entidad del tipo %s con ID: %s", clazz.getName(), id));
    }

}
