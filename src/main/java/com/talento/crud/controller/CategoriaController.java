package com.talento.crud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talento.crud.dto.input.CategoriaInputDTO;
import com.talento.crud.dto.output.CategoriaOutputDTO;
import com.talento.crud.dto.response.StandardResponse;
import com.talento.crud.service.ICategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categorias") 
public class CategoriaController {

    private final ICategoriaService categoriaService;
    
    @Autowired
    public CategoriaController(ICategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<StandardResponse<List<CategoriaOutputDTO>>> listarCategorias() {
        List<CategoriaOutputDTO> categoriaOutputDTOs = categoriaService.listarCategorias();
        StandardResponse<List<CategoriaOutputDTO>> response = new StandardResponse<>("Lista obtenida correctamente",
                                                                                    categoriaOutputDTOs);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping()
    public ResponseEntity<StandardResponse<CategoriaOutputDTO>> crearCatgeoria(@RequestBody CategoriaInputDTO categoriaInputDTO) {        
        CategoriaOutputDTO categoriaOutputDTO = categoriaService.crearCategoria(categoriaInputDTO);
        StandardResponse<CategoriaOutputDTO> response = new StandardResponse<>("Categoria creada correctamente",
                                                                                categoriaOutputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse<CategoriaOutputDTO>> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaInputDTO categoriaInputDTO) {

        CategoriaOutputDTO categoriaOutputDTO = categoriaService.actualizarCategoriaPorId(id, categoriaInputDTO);
        StandardResponse<CategoriaOutputDTO> response = new StandardResponse<>("Categoria actualizada correctamente",
                                                                                categoriaOutputDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse<Void>> eliminarCategoria(@PathVariable Long id) {

        categoriaService.elimniarCategoriaPorId(id);
        return ResponseEntity.noContent().build();
    }

    
}
