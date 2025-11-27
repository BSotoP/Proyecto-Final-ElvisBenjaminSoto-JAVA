package com.talento.crud.dto.input;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaInputDTO {
    private Long id;
    private String nombre;
}
