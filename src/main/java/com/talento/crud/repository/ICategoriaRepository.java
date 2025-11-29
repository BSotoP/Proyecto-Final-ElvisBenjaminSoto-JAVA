package com.talento.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talento.crud.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long>{
    boolean existsByNombre(String nombre);
}
