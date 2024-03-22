package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.models.Permissao;

public interface PermissaoRepository extends JpaRepository<Long, Permissao>{
    
}
