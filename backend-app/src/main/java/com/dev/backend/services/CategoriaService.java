package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.models.Categoria;
import com.dev.backend.repositories.CategoriaRepository;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> listarTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria){
        categoria.setDataCriacao(new Date());
        Categoria categoriaNovo = categoriaRepository.saveAndFlush(categoria);
        return categoriaNovo;
    }

    public Categoria alterar(Categoria categoria){
        categoria.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public void excluir(Long id){
        Categoria categoria = categoriaRepository.findById(id).get();

        categoriaRepository.delete(categoria);

    }
}
