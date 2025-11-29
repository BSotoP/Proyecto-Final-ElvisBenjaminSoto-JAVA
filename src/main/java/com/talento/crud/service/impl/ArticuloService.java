package com.talento.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talento.crud.dto.input.ArticuloInputDTO;
import com.talento.crud.dto.output.ArticuloOutputDTO;
import com.talento.crud.mapper.ArticuloMapper;
import com.talento.crud.model.Articulo;
import com.talento.crud.model.Categoria;
import com.talento.crud.service.IArticuloService;
import com.talento.crud.repository.IArticuloRepository;
import com.talento.crud.repository.ICategoriaRepository;

@Service
public class ArticuloService implements IArticuloService {

    private final IArticuloRepository articuloRepository;
    private final ICategoriaRepository categoriaRepository;
    private final ArticuloMapper articuloMapper;


    @Autowired
    public ArticuloService(IArticuloRepository articuloRepository, ICategoriaRepository categoriaRepository, ArticuloMapper articuloMapper) {
        this.articuloRepository = articuloRepository;
        this.categoriaRepository = categoriaRepository;
        this.articuloMapper = articuloMapper;
    }

  

  

    @Override
    public ArticuloOutputDTO crearArticulo(ArticuloInputDTO articuloInputDTO) {

        Articulo articulo =  articuloMapper.toEntity(articuloInputDTO);

        Categoria categoria = categoriaRepository.findById(articuloInputDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

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
                .orElseThrow(() -> new RuntimeException("Articulo no encontrado"));

        if (articuloInputDTO.getNombre() != null)
        articulo.setNombre(articuloInputDTO.getNombre());

        if (articuloInputDTO.getPrecio() != null)
        articulo.setPrecio(articuloInputDTO.getPrecio());

        if (articuloInputDTO.getImagen() != null)
        articulo.setImagen(articuloInputDTO.getImagen());

        if (articuloInputDTO.getCategoriaId() != null) {
        Categoria categoria = categoriaRepository.findById(articuloInputDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        articulo.setCategoria(categoria);
        }

        articulo = articuloRepository.save(articulo);
        return articuloMapper.toOutput(articulo);
       
    }


    @Override
    public Void eliminarArticuloPorId(Long id) {
        Articulo articulo = articuloRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Articulo no encontrado"));
  
        articuloRepository.deleteById(id);
        return null;
    }

}
