package com.dev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
