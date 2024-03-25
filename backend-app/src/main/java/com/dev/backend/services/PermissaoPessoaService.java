package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.models.Permissao;
import com.dev.backend.models.PermissaoPessoa;
import com.dev.backend.models.Pessoa;
import com.dev.backend.repositories.PermissaoPessoaRepository;
import com.dev.backend.repositories.PermissaoRepository;

@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;
    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vincularPessoaPermissao(Pessoa pessoa) {

        List<Permissao> listaPermissao = permissaoRepository.findByNome("Cliente");

        if(!listaPermissao.isEmpty()) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());

            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }
    }
}
