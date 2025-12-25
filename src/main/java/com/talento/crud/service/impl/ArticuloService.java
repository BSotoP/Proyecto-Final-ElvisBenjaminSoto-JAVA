package com.talento.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talento.crud.dto.input.ArticuloInputDTO;
import com.talento.crud.dto.output.ArticuloOutputDTO;
import com.talento.crud.exceptions.ArticuloNoEncontradaException;
import com.talento.crud.exceptions.CategoriaEsNull;
import com.talento.crud.exceptions.CategoriaNoEncontradaException;
import com.talento.crud.exceptions.InvalidPrecioException;
import com.talento.crud.mapper.ArticuloMapper;
import com.talento.crud.model.Articulo;
import com.talento.crud.model.Categoria;
import com.talento.crud.service.IArticuloService;
import com.talento.crud.repository.IArticuloRepository;
import com.talento.crud.repository.ICategoriaRepository;

@Service
public class ArticuloService implements IArticuloService {
    @Autowired
    private IArticuloRepository articuloRepository;
    @Autowired
    private ICategoriaRepository categoriaRepository;
    @Autowired
    private ArticuloMapper articuloMapper;


    @Override
    public ArticuloOutputDTO crearArticulo(ArticuloInputDTO articuloInputDTO) {

        if(articuloInputDTO.getPrecio() < 0){
            throw new InvalidPrecioException("El precio no pude ser menor a cero");
        }
        if(articuloInputDTO.getCategoriaId() == null){
            throw new CategoriaEsNull("Debe Ingresar categoriaId");
        }

        Articulo articulo =  articuloMapper.toEntity(articuloInputDTO);

        Categoria categoria = categoriaRepository.findById(articuloInputDTO.getCategoriaId())
                .orElseThrow(() -> new CategoriaNoEncontradaException("Categoría no encontrada"));

        articulo.setCategoria(categoria);

        articulo = articuloRepository.save(articulo);
        return articuloMapper.toOutput(articulo);
    }

    

    @Override
    public List<ArticuloOutputDTO> listarArticulos() {
        List<Articulo> articulos = articuloRepository.findAll();
        List<ArticuloOutputDTO> articuloOutputDTOs = articulos.stream()
                .map(articuloMapper::toOutput)
                .toList();
        return articuloOutputDTOs;
    }

    @Override
    public ArticuloOutputDTO actualizarArticuloPorId(Long id, ArticuloInputDTO articuloInputDTO) {

        Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new ArticuloNoEncontradaException("Articulo no encontrado"));

        if (articuloInputDTO.getNombre() != null)
        articulo.setNombre(articuloInputDTO.getNombre());

        if (articuloInputDTO.getPrecio() != null)
        articulo.setPrecio(articuloInputDTO.getPrecio());

        if (articuloInputDTO.getImagen() != null)
        articulo.setImagen(articuloInputDTO.getImagen());

        if (articuloInputDTO.getCategoriaId() != null) {
        Categoria categoria = categoriaRepository.findById(articuloInputDTO.getCategoriaId())
                .orElseThrow(() -> new CategoriaNoEncontradaException("Categoría no encontrada"));
        articulo.setCategoria(categoria);
        }

        articulo = articuloRepository.save(articulo);
        return articuloMapper.toOutput(articulo);
       
    }


    @Override
    public Void eliminarArticuloPorId(Long id) {
        Articulo articulo = articuloRepository.findById(id)
        .orElseThrow(() -> new ArticuloNoEncontradaException("Articulo no encontrado"));
  
        articuloRepository.deleteById(id);
        return null;
    }



    @Override
    public ArticuloOutputDTO getArticuloById(Long id) {
       Articulo articulo = articuloRepository.findById(id)
        .orElseThrow(() -> new ArticuloNoEncontradaException("Articulo no encontrado"));

        return articuloMapper.toOutput(articulo);
    }

}
