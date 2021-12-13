package com.salesianos.triana.dam.EC01T4.errores.modelo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor  @AllArgsConstructor
public class ApiValidationSubError extends ApiSubError{

    private String objeto,campo, mensaje;
    private Object valorRechazado;
}
