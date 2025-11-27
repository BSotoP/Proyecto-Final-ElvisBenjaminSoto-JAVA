package com.talento.crud.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talento.crud.dto.output.ArticuloOutputDTO;
import com.talento.crud.dto.input.ArticuloInputDTO;
import com.talento.crud.model.Articulo;

@Component
public class ArticuloMapper {

    @Autowired
    private final CategoriaMapper categoriaMapper;
    public ArticuloMapper(CategoriaMapper categoriaMapper) {
        this.categoriaMapper = categoriaMapper;
    }

    public ArticuloOutputDTO toOutput(Articulo articulo) {
        if (articulo == null) return null;

        return new ArticuloOutputDTO(
                articulo.getId(),
                articulo.getNombre(),
                articulo.getPrecio(),
                articulo.getImagen(),
                categoriaMapper.toOutput(articulo.getCategoria()));
    }

    public Articulo toEntity(ArticuloInputDTO articuloInputDTO) {
        if (articuloInputDTO == null) return null;

        Articulo articulo = new Articulo();
    
        articulo.setNombre(articuloInputDTO.getNombre());
        articulo.setPrecio(articuloInputDTO.getPrecio());
        articulo.setImagen(articuloInputDTO.getImagen());
        articulo.setDescripcion(articuloInputDTO.getDescripcion());
        return articulo;
    }

}
