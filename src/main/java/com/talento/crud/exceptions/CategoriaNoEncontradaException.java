package com.talento.crud.exceptions;

public class CategoriaNoEncontradaException extends RuntimeException{

    public CategoriaNoEncontradaException(String mensaje){
        super(mensaje);
    }
}
