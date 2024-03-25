package com.dev.backend.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.models.Produto;
import com.dev.backend.models.ProdutoImagens;
import com.dev.backend.repositories.ProdutoImagensRepository;
import com.dev.backend.repositories.ProdutoRepository;

public class ProdutoImagensService {
    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public List<ProdutoImagens> listarTodos(){
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file){
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens produtoImagens = new ProdutoImagens();     
        
        try {

            if(!file.isEmpty()) {
                byte[] bytes = file.getBytes();

                String nomeImagem = String.valueOf(produto.getId())+file.getOriginalFilename();
                Path caminho = Paths.get("c:/imagens/" + nomeImagem);
                Files.write(caminho, bytes);

                produtoImagens.setNome(nomeImagem);
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        produtoImagens.setProduto(produto);
        produtoImagens.setDataCriacao(new Date());
     
        return produtoImagens;
    }

    public ProdutoImagens alterar(ProdutoImagens produtoImagens){
        produtoImagens.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagens);
    }

    public void excluir(Long id){
        ProdutoImagens produtoImagens = produtoImagensRepository.findById(id).get();

        produtoImagensRepository.delete(produtoImagens);

    }
}