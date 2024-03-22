package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.models.Marca;

public interface MarcaRepository extends JpaRepository<Long, Marca> {
    
}
