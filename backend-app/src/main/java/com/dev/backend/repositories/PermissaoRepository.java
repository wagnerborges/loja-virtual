package com.dev.backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.backend.models.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
    
    List<Permissao> findByNome(String nome);
}
