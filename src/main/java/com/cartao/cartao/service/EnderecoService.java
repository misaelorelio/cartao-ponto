package com.cartao.cartao.service;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.model.Endereco;
import com.cartao.cartao.model.Estado;
import com.cartao.cartao.repository.CidadeRepository;
import com.cartao.cartao.repository.EnderecoRepository;
import com.cartao.cartao.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public Page<Endereco> listarEnderecos(Pageable pageable) {
        return enderecoRepository.findAll(pageable);
    }

    public Endereco salvarEndereco(Endereco endereco) throws Exception {

        List<Cidade> cidades = cidadeRepository.findAll();
            for (Cidade c: cidades) {
                c.getId();
                var ids = endereco.getCidade().getId().compareTo(c.getId());
                if (endereco == null || cidades.isEmpty() || ids > 0) {
                    throw new Exception();
                }
            }
            return enderecoRepository.save(endereco);
    }

    public Endereco alterar(Endereco endereco) throws Exception {
        try {
            Endereco end = enderecoRepository.save(endereco);
            return end;
        }
        catch (Exception e) {
            throw new Exception();
        }
    }
}
