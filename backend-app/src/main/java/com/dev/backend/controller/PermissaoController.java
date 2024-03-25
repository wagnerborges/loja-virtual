package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.models.Permissao;
import com.dev.backend.services.PermissaoService;

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

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")        
    public List<Permissao> listarTodos() {
        return permissaoService.buscarTodos();
    }
    
    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao marca){
        return permissaoService.inserir(marca);

    }

    @PutMapping("/")    
    public Permissao alterar(@RequestBody Permissao marca) {
        return permissaoService.alterar(marca);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }
    
}
