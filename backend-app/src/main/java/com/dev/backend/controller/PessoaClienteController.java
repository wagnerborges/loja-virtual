package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.dtos.PessoaClienteRequestDTO;
import com.dev.backend.models.Pessoa;
import com.dev.backend.services.PessoaClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {

    @Autowired
    private PessoaClienteService pessoaClienteService;

    @PostMapping("/")
    public Pessoa inserir(@RequestBody PessoaClienteRequestDTO cliente){        
        return pessoaClienteService.inserir(cliente);
    }    
}
