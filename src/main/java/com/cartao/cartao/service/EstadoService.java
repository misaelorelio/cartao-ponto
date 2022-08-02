package com.cartao.cartao.service;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.model.Estado;
import com.cartao.cartao.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado inserirEstado(@RequestBody Estado estado) throws Exception {
       try {
           if(estado == null) {
               ResponseEntity.status(HttpStatus.BAD_REQUEST)
                       .body("Erro");
           }
           ResponseEntity.status(HttpStatus.CREATED)
                   .body("Sucesso");
           return estadoRepository.save(estado);
       }
       catch (Exception e) {
           throw new Exception(e.getMessage());
       }
    }
}