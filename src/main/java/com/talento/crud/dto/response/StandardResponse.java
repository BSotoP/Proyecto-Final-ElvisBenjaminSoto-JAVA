package com.talento.crud.dto.response;

import lombok.Getter;

@Getter
public class StandardResponse<T> {

    private String fecha;
    private String mensaje;
    private T data;

    public StandardResponse(String fecha, String mensaje, T data) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.data = data;
    }

}
