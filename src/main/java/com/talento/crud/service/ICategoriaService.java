package com.talento.crud.service;

import java.util.List;

import com.talento.crud.dto.input.CategoriaInputDTO;
import com.talento.crud.dto.output.CategoriaOutputDTO;


public interface ICategoriaService {

    public CategoriaOutputDTO crearCategoria(CategoriaInputDTO categoriaInputDTO);
    public List<CategoriaOutputDTO> listarCategorias();
    public Void elimniarCategoriaPorId(Long id);
    public CategoriaOutputDTO actualizarCategoriaPorId(Long id, CategoriaInputDTO categoriaInputDTO);
}
