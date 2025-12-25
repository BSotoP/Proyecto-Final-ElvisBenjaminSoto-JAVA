package com.talento.crud.exceptions;

public class ArticuloNoEncontradaException extends RuntimeException{

    public ArticuloNoEncontradaException(String mensaje){
        super(mensaje);
    }
}
