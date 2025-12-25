package com.talento.crud.exceptions;

public class InvalidPrecioException extends RuntimeException{

    public InvalidPrecioException(String mensaje){
        super(mensaje);
    }
}
