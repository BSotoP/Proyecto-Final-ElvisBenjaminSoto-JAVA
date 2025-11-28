package com.talento.crud.controller;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talento.crud.dto.input.CategoriaInputDTO;
import com.talento.crud.dto.output.CategoriaOutputDTO;
import com.talento.crud.dto.response.StandardResponse;
import com.talento.crud.service.ICategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

        if(categoriaOutputDTOs==null){

            StandardResponse<List<CategoriaOutputDTO>> response =
                new StandardResponse<>(
                        LocalDateTime.now().toString(),
                        "No se pudo obtener la lista de categorías",
                        null
                );

            return ResponseEntity.internalServerError().body(response);
        }

        StandardResponse<List<CategoriaOutputDTO>> response = new StandardResponse<>(
                                                                                LocalDateTime.now().toString(),
                                                                                "Lista obtenida correctamente",
                                                                                categoriaOutputDTOs);
            return ResponseEntity.ok(response);
    }
    
    @PostMapping()
    public ResponseEntity<StandardResponse<CategoriaOutputDTO>> crearCatgeoria(@RequestBody CategoriaInputDTO categoriaInputDTO) {        
        CategoriaOutputDTO categoriaOutputDTO = categoriaService.crearCategoria(categoriaInputDTO);
        if(categoriaOutputDTO == null){
            StandardResponse<CategoriaOutputDTO> response =  new StandardResponse<>(
                                                                                LocalDateTime.now().toString(),
                                                                                "Error al crear la categoria", 
                                                                                null);
            return ResponseEntity.internalServerError().body(response);
        }

        StandardResponse<CategoriaOutputDTO> response = new StandardResponse<>(
                                                                                LocalDateTime.now().toString(),
                                                                                "Categoria creada correctamente",
                                                                                categoriaOutputDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

     
    }
    


    
}
