package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.models.Estado;
import com.dev.backend.repositories.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;
    
    public List<Estado> listarTodos(){
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void excluir(Long id){
        Estado estado = estadoRepository.findById(id).get();

        estadoRepository.delete(estado);

    }
}
