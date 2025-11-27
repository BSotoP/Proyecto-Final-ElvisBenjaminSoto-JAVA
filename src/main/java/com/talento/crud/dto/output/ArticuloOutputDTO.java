package com.talento.crud.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloOutputDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private String imagen;
    private CategoriaOutputDTO categoria;

}
