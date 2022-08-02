package com.cartao.cartao.controller;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.model.Estado;
import com.cartao.cartao.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<Estado> salvarEstado(@RequestBody Estado estado) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.inserirEstado(estado));
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());

        }

    }
}
