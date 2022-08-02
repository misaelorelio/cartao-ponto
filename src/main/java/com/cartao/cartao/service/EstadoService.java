package com.cartao.cartao.service;

import com.cartao.cartao.model.Cidade;
import com.cartao.cartao.model.Estado;
import com.cartao.cartao.repository.EstadoRepository;
import org.apache.tomcat.util.codec.binary.StringUtils;
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
            for(int i = 0; i < estado.getSigla().length(); i++){
                char sigla = estado.getSigla().charAt(i);
                if(estado.getNome() == null || estado.getSigla() == null || estado.getSigla() == "" || Character.isDigit(sigla)) {
                    throw new Exception();
                }
            }
       try {

           return estadoRepository.save(estado);
       }
       catch (Exception e) {
           throw new Exception(e.getMessage());
       }
    }
}
