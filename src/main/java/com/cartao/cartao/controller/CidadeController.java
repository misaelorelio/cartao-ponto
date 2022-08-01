package com.cartao.cartao.controller;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.repository.CidadeRepository;
import com.cartao.cartao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public Page<Cidade> listaCidades(Pageable pageable) {
        return cidadeService.listaCidades(pageable);
    }
    @PostMapping
    public void cadastrarCidade(@RequestBody Cidade cidade) {
        cidadeService.inserirCidade(cidade);

    }

}
