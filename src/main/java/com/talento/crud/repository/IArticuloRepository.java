package com.talento.crud.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talento.crud.model.Articulo;

@Repository
public interface IArticuloRepository extends JpaRepository<Articulo, Long> {

    List<Articulo> findByNombre(String nombre);
   
}

