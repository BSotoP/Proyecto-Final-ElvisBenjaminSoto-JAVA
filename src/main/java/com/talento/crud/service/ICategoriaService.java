package com.talento.crud.service;

import java.util.List;

import com.talento.crud.dto.input.CategoriaInputDTO;
import com.talento.crud.dto.output.CategoriaOutputDTO;


public interface ICategoriaService {

    public CategoriaOutputDTO crearCategoria(CategoriaInputDTO categoriaInputDTO);
    public List<CategoriaOutputDTO> listarCategorias();
    //public ArticuloOutputDTO actualizarArticuloPorId(Long id, ArticuloInputDTO articuloInputDTO);
    //public String eliminarArticuloPorId(String id);
    public CategoriaOutputDTO actualizarCategoriaPorId(Long id, CategoriaInputDTO categoriaInputDTO);
}
