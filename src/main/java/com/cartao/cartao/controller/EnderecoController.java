package com.cartao.cartao.controller;

import com.cartao.cartao.model.Endereco;
import com.cartao.cartao.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public Page<Endereco> listarEnderecos(Pageable pageable) {
        return enderecoService.listarEnderecos(pageable);
    }

    @PostMapping
    public Endereco salvarEndereco(@RequestBody Endereco endereco) {

        try {
            return enderecoService.salvarEndereco(endereco);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
