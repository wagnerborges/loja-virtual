package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.models.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
    
}