package com.cartao.cartao.controller;

import com.cartao.cartao.model.Colaborador;
import com.cartao.cartao.model.Empresa;
import com.cartao.cartao.service.ColaboradorService;
import com.cartao.cartao.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public Page<Colaborador> listarColaborador(Pageable pageable) {
        return colaboradorService.listarColaborador(pageable);
    }

    @PostMapping
    public Colaborador inserirColaborador(@RequestBody Colaborador colaborador) throws Exception {
        if(colaborador != null) {
            return colaboradorService.inserirColaborador(colaborador);
        }else {
            throw new Exception();
        }
    }

    @PutMapping
    public Colaborador atualizarColaborador(@RequestBody Colaborador colaborador) throws Exception {
        if(colaborador != null && colaborador.getId() != null) {
            return colaboradorService.atualizarColaborador(colaborador);
        }else {
            throw new Exception();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deletarColaborador(@RequestBody Colaborador colaborador) throws Exception {
        if(colaborador != null && colaborador.getId() != null) {
            colaboradorService.atualizarColaborador(colaborador);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Excluido com sucesso");
        }else {
            throw new Exception();
        }
    }
}
