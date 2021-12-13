package com.salesianos.triana.dam.EC01T4.errores;

import com.salesianos.triana.dam.EC01T4.errores.excepciones.NotFoundException;
import com.salesianos.triana.dam.EC01T4.errores.modelo.ApiError;
import com.salesianos.triana.dam.EC01T4.errores.modelo.ApiSubError;
import com.salesianos.triana.dam.EC01T4.errores.modelo.ApiValidationSubError;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(HttpStatus status,NotFoundException ex, WebRequest request) {
        return buildApiError(status,ex, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildApiError(status,"Errores varios en la validación", request, ex.getFieldErrors()
                .stream().map(error -> ApiValidationSubError.builder()
                        .objeto(error.getObjectName())
                        .campo(error.getField())
                        .valorRechazado(error.getRejectedValue())
                        .mensaje(error.getDefaultMessage())
                        .build())
                .collect(Collectors.toList())
        );
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildApiError(status,ex, request);
    }

    private ResponseEntity<Object> buildApiError(HttpStatus status, Exception ex, WebRequest request) {
        return ResponseEntity
                .status(status)
                .body(new ApiError(status, ex.getMessage(), ((ServletWebRequest) request).getRequest().getRequestURI()));

    }

    private ResponseEntity<Object> buildApiError(HttpStatus status,String mensaje, WebRequest request, List<ApiSubError> subErrores) {
        return ResponseEntity
                .status(status)
                .body(new ApiError(status, mensaje, ((ServletWebRequest) request).getRequest().getRequestURI(), subErrores));

    }


}
