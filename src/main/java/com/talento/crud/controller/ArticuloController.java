package com.talento.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.talento.crud.dto.input.ArticuloInputDTO;
import com.talento.crud.dto.output.ArticuloOutputDTO;
import com.talento.crud.service.IArticuloService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articulos") //
public class ArticuloController {
    
    private final IArticuloService articuloService;

    @Autowired
    public ArticuloController(IArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @PostMapping
    private ArticuloOutputDTO crearArticulo(@RequestBody ArticuloInputDTO articuloInputDTO) {
        return articuloService.crearArticulo(articuloInputDTO);
    }

    @GetMapping
    private List<ArticuloOutputDTO> listarArticulos() {
        return articuloService.listarArticulos();
    }
    
    @PutMapping("/{id}")
    private ArticuloOutputDTO actualizarArticulo(@PathVariable Long id, @RequestBody ArticuloInputDTO articuloInputDTO) {
        return articuloService.actualizarArticuloPorId(id, articuloInputDTO);
    }

    @DeleteMapping("/{id}")
    private String eliminarArticulo(@PathVariable String id) {
        return articuloService.eliminarArticuloPorId(id);
    }

}
