package com.cartao.cartao.service;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Page<Cidade> listaCidades(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }
}
