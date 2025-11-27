package com.talento.crud.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloInputDTO {
    private String nombre;
    private Double precio;
    private String imagen;
    private String descripcion;
    private Long categoriaId;

}
