package com.talento.crud.mapper;

import com.talento.crud.dto.output.CategoriaOutputDTO;
import com.talento.crud.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {
    
    public CategoriaOutputDTO toOutput(Categoria categoria) {
        if (categoria == null) return null;

        return new CategoriaOutputDTO(categoria.getId(), categoria.getNombre());

    }

    // Este es el método que te falta
    public Categoria fromId(Long id) {
        if (id == null) return null;
        Categoria categoria = new Categoria();
        categoria.setId(id);
        return categoria;
    }

    public Categoria toEntity(CategoriaOutputDTO categoriaOutputDTO) {
        if (categoriaOutputDTO == null) return null;

        Categoria categoria = new Categoria();
        categoria.setId(categoriaOutputDTO.getId());
        categoria.setNombre(categoriaOutputDTO.getNombre());

        return categoria;
    }
}
