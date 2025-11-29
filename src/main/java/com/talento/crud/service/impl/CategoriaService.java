package com.talento.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talento.crud.dto.input.CategoriaInputDTO;
import com.talento.crud.dto.output.CategoriaOutputDTO;
import com.talento.crud.mapper.CategoriaMapper;
import com.talento.crud.model.Categoria;
import com.talento.crud.repository.ICategoriaRepository;
import com.talento.crud.service.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService{

    private final ICategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;
    
    @Autowired
    public CategoriaService(ICategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper){
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public List<CategoriaOutputDTO> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaOutputDTO> categoriasOutputDTO= categorias
        .stream()
        .map(categoriaMapper::toOutput)
        .toList();

        return categoriasOutputDTO;
    
    }

    @Override
    public CategoriaOutputDTO crearCategoria(CategoriaInputDTO categoriaInputDTO) {
         //TODO: Agregar Exception personalizados
        // if (categoriaInputDTO.getNombre() == null || categoriaInputDTO.getNombre().isBlank()) {
        //     throw new IllegalArgumentException("El nombre es obligatorio");
        // }

        //TODO: Agregar Exception personalizados
        // if (categoriaRepository.existsByNombre(categoriaInputDTO.getNombre())) {
        // throw new RuntimeException("Ya existe una categoría con ese nombre");
        // }

        Categoria categoria = categoriaMapper.toEntity(categoriaInputDTO);
        categoria = categoriaRepository.save(categoria);

        return categoriaMapper.toOutput(categoria); 
    
    }


    @Override
    public CategoriaOutputDTO actualizarCategoriaPorId(Long id, CategoriaInputDTO categoriaInputDTO) {

         //TODO: Agregar Exception personalizados y retornar mensaje
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        if (categoriaInputDTO.getNombre() != null){
            categoria.setNombre(categoriaInputDTO.getNombre());
        }
       

        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toOutput(categoria);
       
    }

    @Override
    public Void elimniarCategoriaPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
  
        categoriaRepository.deleteById(id);
        return null;
    }


}
