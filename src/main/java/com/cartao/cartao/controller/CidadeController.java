package com.cartao.cartao.controller;

import com.cartao.cartao.model.Cidade;
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
    public Page<Cidade> listarCidades(Pageable pageable) {
        return cidadeService.listarCidades(pageable);
    }
    @PostMapping
    public ResponseEntity<String> salvarCidade(@RequestBody Cidade cidade) throws Exception {
        try {
            cidadeService.salvarCidade(cidade);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso");
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }

}
