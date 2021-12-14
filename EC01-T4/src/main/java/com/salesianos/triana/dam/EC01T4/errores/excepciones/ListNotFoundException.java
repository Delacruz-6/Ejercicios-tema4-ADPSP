package com.salesianos.triana.dam.EC01T4.errores.excepciones;

public class ListNotFoundException extends NotFoundException{
    public ListNotFoundException(Class clazz) {
        super(String.format("No se pueden encontrar elementos del tipo %s ", clazz.getName()));
    }
}
