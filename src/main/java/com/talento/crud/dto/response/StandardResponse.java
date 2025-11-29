package com.talento.crud.dto.response;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;

@Getter
@JsonPropertyOrder({ "fecha", "mensaje", "data" })
public class StandardResponse<T> {

    private String fecha;
    private String mensaje;
    private T data;

    public StandardResponse(String mensaje, T data) {
        this.fecha = LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.mensaje = mensaje;
        this.data = data;
    }

}
