package com.cartao.cartao.controller;

import com.cartao.cartao.model.Horas;
import com.cartao.cartao.service.HorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horas")
public class HorasController {

    @Autowired
    private HorasService horasService;

    @GetMapping
    public Page<Horas> listarHoras(Pageable pageable) {
        return horasService.listarHorasr(pageable);
    }

    @PostMapping
    public Horas inserirHoras(@RequestBody Horas horas) throws Exception {
        if(horas != null) {
            return horasService.inserirHoras(horas);
        }else {
            throw new Exception();
        }
    }

    @PutMapping
    public Horas atualizarHoras(@RequestBody Horas horas) throws Exception {
        if(horas != null && horas.getId() != null) {
            return horasService.atualizarHoras(horas);
        }else {
            throw new Exception();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deletarHoras(@RequestBody Horas horas) throws Exception {
        if(horas != null && horas.getId() != null) {
            horasService.atualizarHoras(horas);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Excluido com sucesso");
        }else {
            throw new Exception();
        }
    }
}
