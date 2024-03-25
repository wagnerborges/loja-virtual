package com.dev.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.models.ProdutoImagens;

public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long>{
    
}
