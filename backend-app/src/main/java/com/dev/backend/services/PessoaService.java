package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.models.Pessoa;
import com.dev.backend.repositories.PessoaRepository;

@Service
public class PessoaService {
       @Autowired
    private PessoaRepository pessoaRepository;
    
    public List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa pessoa){
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
        return pessoaNovo;
    }

    public Pessoa alterar(Pessoa pessoa){
        pessoa.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void excluir(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();

        pessoaRepository.delete(pessoa);

    }
}
