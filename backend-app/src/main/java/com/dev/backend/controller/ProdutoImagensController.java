package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.models.ProdutoImagens;
import com.dev.backend.services.ProdutoImagensService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/produto-imagens")
public class ProdutoImagensController {
    
    @Autowired
    private ProdutoImagensService produtoImagensService;

    @GetMapping("/")        
    public List<ProdutoImagens> listarTodos() {
        return produtoImagensService.listarTodos();
    }
    
    @PostMapping("/")
    public ProdutoImagens inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file){
        return produtoImagensService.inserir(idProduto, file);

    }

    @PutMapping("/")    
    public ProdutoImagens alterar(@RequestBody ProdutoImagens produto) {
        return produtoImagensService.alterar(produto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        produtoImagensService.excluir(id);
        return ResponseEntity.ok().build();
    }    
}