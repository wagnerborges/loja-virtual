package com.dev.backend.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.dtos.PessoaClienteRequestDTO;
import com.dev.backend.models.Pessoa;
import com.dev.backend.repositories.PessoaRepository;

@Service
public class PessoaClienteService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;
    @Autowired
    private EmailService emailService;
    
    
    public Pessoa inserir(PessoaClienteRequestDTO pessoaClienteRequestDTO){
        
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissao(pessoaNova);

        //emailService.enviarEmailSimple(pessoa.getEmail(), "Cadastro de Cliente", "Cliente Cadastrado com Sucesso!!! Seja Bem-vindo!");
        
        Map<String, Object> map = new HashMap<>();
        map.put("nome", pessoa.getNome());
        map.put("mensagem", "Cliente Cadastrado com sucesso");

        emailService.enviarEmailTemplate(pessoa.getEmail(), "Cadastro Realizado com Sucesso!", map);

        return pessoa;
    }    
}
