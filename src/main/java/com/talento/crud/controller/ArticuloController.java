package com.talento.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.talento.crud.dto.response.StandardResponse;
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
    private ResponseEntity<StandardResponse<ArticuloOutputDTO>> crearArticulo(@RequestBody ArticuloInputDTO articuloInputDTO) {
        ArticuloOutputDTO articuloOutputDTO = articuloService.crearArticulo(articuloInputDTO);
        StandardResponse<ArticuloOutputDTO> response = new StandardResponse<>("Articulo creado correctamente",
                                                                                articuloOutputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    private ResponseEntity<StandardResponse<List<ArticuloOutputDTO>>> listarArticulos() {
        List<ArticuloOutputDTO> articulos = articuloService.listarArticulos();
        StandardResponse<List<ArticuloOutputDTO>> response = new StandardResponse<>("Lista obtenida correctamente",
                                                                                    articulos);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    private ResponseEntity<StandardResponse<ArticuloOutputDTO>> actualizarArticulo(@PathVariable Long id, @RequestBody ArticuloInputDTO articuloInputDTO) {
        ArticuloOutputDTO articuloOutputDTO = articuloService.actualizarArticuloPorId(id, articuloInputDTO);
        StandardResponse<ArticuloOutputDTO> response = new StandardResponse<>("Articulo actualizado correctamente",
                                                                                articuloOutputDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<StandardResponse<Void>> eliminarArticulo(@PathVariable Long id) {
        articuloService.eliminarArticuloPorId(id);
        return ResponseEntity.noContent().build();
    }

}
