package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.models.Cidade;
import com.dev.backend.services.CidadeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
    
    @Autowired
    private CidadeService cidadeService;
    
    @GetMapping("/")        
    public List<Cidade> listarTodos() {
        return cidadeService.listarTodos();
    }
    
    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade cidade){
        return cidadeService.inserir(cidade);

    }

    @PutMapping("/")    
    public Cidade alterar(@RequestBody Cidade cidade) {
        return cidadeService.alterar(cidade);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        cidadeService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
