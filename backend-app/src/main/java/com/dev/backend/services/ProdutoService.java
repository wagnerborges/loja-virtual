package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.models.Produto;
import com.dev.backend.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Produto inserir(Produto Produto){
        Produto.setDataCriacao(new Date());
        Produto produtoNovo = produtoRepository.saveAndFlush(Produto);
        return produtoNovo;
    }

    public Produto alterar(Produto Produto){
        Produto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(Produto);
    }

    public void excluir(Long id){
        Produto Produto = produtoRepository.findById(id).get();

        produtoRepository.delete(Produto);

    }
}
