package com.cartao.cartao.controller;

import com.cartao.cartao.model.Estado;
import com.cartao.cartao.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;


    @GetMapping
    public Page<Estado> listarEstados(Pageable pageable) {
        return estadoService.listarEstados(pageable);
    }
    @PostMapping
    public ResponseEntity<Estado> salvarEstado(@RequestBody Estado estado) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.inserirEstado(estado));
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());

        }

    }
    @PutMapping
    public Estado alterarEstado(@RequestBody Estado estado) {
        Estado es = estadoService.alterarEstado(estado);
        return es;
    }
    @DeleteMapping("/{id}")
    public void deletarEstado(@PathVariable("id") Integer id) {
        estadoService.deletarEstado(id);
    }
}
