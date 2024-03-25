package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
