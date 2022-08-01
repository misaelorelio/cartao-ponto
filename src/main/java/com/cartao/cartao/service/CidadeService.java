package com.cartao.cartao.service;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Page<Cidade> listaCidades(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }

    public ResponseEntity<String> inserirCidade(@RequestBody Cidade cidade) {
        if (cidade == null) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao salvar cidade");
        }
            cidadeRepository.save(cidade);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Cadastrado com sucesso");
    }
}
