package com.talento.crud.service;

import com.talento.crud.dto.output.ArticuloOutputDTO;

import java.util.List;

import com.talento.crud.dto.input.ArticuloInputDTO;

public interface IArticuloService {
    public ArticuloOutputDTO crearArticulo(ArticuloInputDTO articuloInputDTO);
    public List<ArticuloOutputDTO> listarArticulos();
    public ArticuloOutputDTO actualizarArticuloPorId(Long id, ArticuloInputDTO articuloInputDTO);
    public Void eliminarArticuloPorId(Long id);
    public ArticuloOutputDTO getArticuloById(Long id);
}
