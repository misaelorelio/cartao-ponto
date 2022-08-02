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

            if (endereco == null || cidades.isEmpty()) {
                throw new Exception();
            }

            try {
                return enderecoRepository.save(endereco);
            }
            catch (Exception e) {
                throw new Exception(e.getMessage());
            }
    }
}
