package com.dev.backend.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.models.Pessoa;
import com.dev.backend.repositories.PessoaRepository;

@Service
public class PessoaGerenciamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    public String solicitarCodigo(String email) {

        Pessoa pessoa = pessoaRepository.findByEmail(email);
        String codigoRecuperacao = gerarCodigoRecuperacaoSenha(pessoa.getId());
        pessoa.setCodigoRecuperacaoSenha(codigoRecuperacao);
        pessoa.setDataEnvioCodigo(new Date());
        pessoaRepository.saveAndFlush(pessoa);
        
        emailService.enviarEmailSimple(
            pessoa.getEmail(), 
        "Recuperação de Senha",
         "Olá! Seu código para a recuperação da sua senha é: "+pessoa.getCodigoRecuperacaoSenha());
      
        return "Código enviado!";
    }

    public String alterarSenha(Pessoa pessoa) {
        
        Pessoa p = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());
        Date diferenca = new Date(new Date().getTime()-p.getDataEnvioCodigo().getTime());

        if((diferenca.getTime()/1000) < 900) {

            p.setSenha(pessoa.getSenha());
            p.setCodigoRecuperacaoSenha(null);

            pessoaRepository.saveAndFlush(p);

            return "Alterado com sucesso";

        } else {
            return "Tempo expirado. Solicite um novo código";
        }
    }

    private String gerarCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date())+""+id;
    }
}
