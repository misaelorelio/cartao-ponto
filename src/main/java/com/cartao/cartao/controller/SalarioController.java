package com.cartao.cartao.controller;

import com.cartao.cartao.model.Salario;
import com.cartao.cartao.service.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salario")
public class SalarioController {

    @Autowired
    private SalarioService salarioService;

    @GetMapping
    public Page<Salario> listarSalario(Pageable pageable) {
        return salarioService.listarSalario(pageable);
    }

    @PostMapping
    public Salario inserirSalario(@RequestBody Salario salario) throws Exception {
        if(salario != null) {
            return salarioService.salvarSalario(salario);
        }else {
            throw new Exception();
        }
    }

    @PutMapping
    public Salario atualizarSalario(@RequestBody Salario salario) throws Exception {
        if(salario != null && salario.getId() != null) {
            return salarioService.alterarSalario(salario);
        }else {
            throw new Exception();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deletarSalario(@RequestBody Salario salario) throws Exception {
        if(salario != null && salario.getId() != null) {
            //salarioService.atualizarColaborador(salario);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Excluido com sucesso");
        }else {
            throw new Exception();
        }
    }
}
