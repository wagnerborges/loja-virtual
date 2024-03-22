package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Long, Categoria>{
    
}
