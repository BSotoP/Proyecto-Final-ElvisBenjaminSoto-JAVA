package com.talento.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.talento.crud.dto.response.StandardResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(InvalidPrecioException.class)
    public ResponseEntity<StandardResponse<Void>> handleInvalidPrecio(InvalidPrecioException ex) {

        StandardResponse<Void> response =
                new StandardResponse<>(ex.getMessage(), null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CategoriaNoEncontradaException.class)
    public ResponseEntity<StandardResponse<Void>> handleCategoriaNoEncontrada(CategoriaNoEncontradaException ex) {

        StandardResponse<Void> response =
                new StandardResponse<>(ex.getMessage(), null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CategoriaEsNull.class)
    public ResponseEntity<StandardResponse<Void>> handleCategoriaEsNull(CategoriaEsNull ex) {

        StandardResponse<Void> response =
                new StandardResponse<>(ex.getMessage(), null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    @ExceptionHandler(ArticuloNoEncontradaException.class)
    public ResponseEntity<StandardResponse<Void>> handleArticuloNoEncontrado(ArticuloNoEncontradaException ex) {

        StandardResponse<Void> response =
                new StandardResponse<>(ex.getMessage(), null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
