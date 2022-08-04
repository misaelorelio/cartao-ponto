package com.cartao.cartao.controller;

import com.cartao.cartao.model.Empresa;
import com.cartao.cartao.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public Page<Empresa> listarEmpresas(Pageable pageable) {
        return empresaService.listarEmpresas(pageable);
    }

    @PostMapping
    public Empresa inserirEmpresa(@RequestBody Empresa empresa) throws Exception {
        if(empresa != null) {
            return empresaService.inserirEmpresa(empresa);
        }else {
            throw new Exception();
        }
    }

    @PutMapping
    public Empresa atualizarEmpresa(@RequestBody Empresa empresa) throws Exception {
        if(empresa != null && empresa.getId() != null) {
            return empresaService.atualizarEmpresa(empresa);
        }else {
            throw new Exception();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deletarEmpresa(@RequestBody Empresa empresa) throws Exception {
        if(empresa != null && empresa.getId() != null) {
            empresaService.atualizarEmpresa(empresa);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Excluido com sucesso");
        }else {
            throw new Exception();
        }
    }
}
